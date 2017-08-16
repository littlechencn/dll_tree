var width = 1000;
var height = 800;
var maxDepth = 1; //定义一个显示最大层数（0,1...），显示前两层节点maxDepth=1；
var circleR = 18;// 画圈节点大小，半径为28

//边界空白
var padding = {left: 280, right: 50, top: 20, bottom: 20};

//增加svg容器；
var svg = d3.select("#svgDiv")
    .append("svg")
    .attr("width", width + padding.left + padding.right)
    .attr("height", height + padding.top + padding.bottom)
    .append("g")
    .attr("transform", "translate(" + padding.left + "," + padding.top + ")");

//树状图布局
var tree = d3.layout.tree()
    .size([height, width]);

//对角线生成器
var diagonal = d3.svg.diagonal()
    .projection(function (d) {
        if (maxDepth == 999) {
            $('.node').css("visibility", "");
        }
        return [d.y, d.x];
    });

var root_temp;

//D3初始化函数；
function d3Inint(error, root) {
    //给第一个节点添加初始坐标x0和y0
    root.x0 = height / 2;
    root.y0 = 0;
    //以第一个节点为起始节点，重绘
    root_temp = root;
    redraw(root);
}

//重绘函数
function redraw(source) {
    svg.selectAll("circle").remove();
    svg.selectAll("g").remove();
    svg.selectAll("text").remove();

    //（1）.计算节点和连线的位置
    //应用布局，计算几点和连线
    var nodes = tree.nodes(root_temp);
    nodes.forEach(function (d) {
        if (d.depth >= maxDepth) {
            if (d.children) { //如果有子节点
                d._children = d.children; //将该子节点保存到 _children
                d.children = null;  //将子节点设置为null
            }
        }
        else {
            nodes = tree.nodes(root_temp);
        }
    });

    var links = tree.links(nodes);
    links.forEach(function (d) {
        if (d.source.depth > maxDepth) {
            if (d.target) { //如果有子节点
                // d._children = d.children; //将该子节点保存到 _children
                d.target = null;  //将子节点设置为null
            }
        }
        else {
            links = tree.links(nodes);
        }
    });

    //重新计算节点的y坐标
    nodes.forEach(function (d) {
        d.y = d.depth * 180;
    });

    //（2）.节点的处理
    //获取节点的update部分
    var nodeUpdate = svg.selectAll(".node").data(nodes, function (d) {
        return d.name;
    });

    //获取节点的enter部分
    var nodeEnter = nodeUpdate.enter();

    //获取节点的exit部分
    var nodeExit = nodeUpdate.exit();

    //1. 节点的Enter 部分处理方法
    var enterNodes = nodeEnter.append("g")
        .attr("class", "node")
        .style("visibility", function (d) {
            if (d.depth > maxDepth) {
                return "hidden";
            }
            else {
                return "";
            }
        })
        .attr("transform", function (d) {
            return "translate(" + source.y0 + "," + source.x0 + ")";
        })
        .on("click", function (d) {
            toggle(d);
        });

    enterNodes.append("circle")
        .attr("r", 0)
        .attr("class", function (d) {
            if (d.depth == 0) {
                return "circle1";
            } else if (d.depth == 1) {
                return "circle2";
            } else if (d.depth == 2) {
                return "circle3";
            } else {
                return "circle4";
            }
        });

    //.style("fill",
    //function (d) {
    //    return d._children ? "lightsteelblue" : "#fff";
    // })
    //  .style("class", "circle2");

    enterNodes.append("text")
        .attr("x", function (d) {
            return d.children || d._children ? -14 : 14;
        })
        .attr("dy", ".35em")
        .attr("text-anchor", function (d) {
            return d.children || d._children ? "end" : "start";
        })
        .text(function (d) {
            return d.name;
        })
        .style("fill-opacity", 0)
        .style("text-decoration", function (d) {
            return d._children ? "underline" : "none";
        })
        .style("fill", function (d) {
            if (d.dependence_api_status == "fixme")
                return "red";
            if (d.dependence_api_status == "stub")
                return "blue";
            else
                return "black";
        });

    //2. 节点的Update 部分的处理方法
    var updateNodes = nodeUpdate.transition()
        .duration(500)
        .attr("transform", function (d) {
            return "translate(" + d.y + "," + d.x + ")";
        });

    updateNodes.select("circle")
        .attr("r", circleR)
        .attr("class", function (d) {
            if (d.depth == 0) {
                return "circle1";
            } else if (d.depth == 1) {
                return "circle2";
            } else if (d.depth == 2) {
                return "circle3";
            } else {
                return "circle4";
            }
        });

    //.style("fill", function (d) { return d._children ? "lightsteelblue" : "#fff"; })

    updateNodes.select("text")
        .style("fill-opacity", 1)
        .style("text-decoration", function (d) {
            return d._children ? "underline" : "none";
        });

    //3. 节点的Exit 部分处理方法
    var exitNodes = nodeExit.transition()
        .duration(500)
        .attr("transform", function (d) {
            return "translate(" + source.y + "," + source.x + ")";
        })
        .remove();

    exitNodes.select("circle")
        .attr("r", 0);

    exitNodes.select("text")
        .style("fill-opacity", 0);

    //（3） 连线的处理
    //获取连线的update部分
    var linkUpdate = svg.selectAll(".link")
        .data(links, function (d) {
            return d.target.name;
        });

    //获取连线的enter部分
    var linkEnter = linkUpdate.enter();

    //获取连线的exit部分
    var linkExit = linkUpdate.exit();

    //1. 连线的Enter 部分的处理方法
    linkEnter.insert("path", ".node")
        .attr("class", "link")
        .style("visibility", function (d) {
            if (d.target.depth > maxDepth) {
                return "hidden";
            }
            else {
                return "";
            }
        })
        .attr("d", function (d) {
            var o = {x: source.x0, y: source.y0};
            return diagonal({source: o, target: o});
        })
        .transition()
        .duration(500)
        .attr("d", diagonal);

    //2. 连线的 Update 部分的处理方法
    linkUpdate.transition()
        .duration(500)
        .attr("d", diagonal);

    //3. ���ߵ� Exit ���ֵĴ���취
    linkExit.transition()
        .duration(500)
        .attr("d", function (d) {
            var o = {x: source.x, y: source.y};
            return diagonal({source: o, target: o});
        })
        .remove();

    // （4） 将当前的节点坐标保存在变量x0、y0里，以备更新时使用
    nodes.forEach(function (d) {
        d.x0 = d.x;
        d.y0 = d.y;
    });
}

//切换开关，d 为被点击的节点
function toggle(d) {
    maxDepth = 999;
    if (d.children) { //如果有子节点
        d._children = d.children; //将子节点保存到_children
        d.children = null;  //将自己点设置为null
    } else {  //如果没有子节点
        d.children = d._children; //从 _children 取回原来的子节点
        d._children = null; //将children设置为 null
    }
    redraw(d);
}

