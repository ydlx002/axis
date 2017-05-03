package com.ydlx.utils;

import com.ydlx.domain.info.MenuInfo;

import java.util.List;

/**
 * Created by ydlx on 2017/4/30.
 */
public class MenuUtil {

    public String generateMenu(List<MenuInfo> menuInfoList){
        StringBuilder sb = new StringBuilder();
        for(int i=0, size= menuInfoList.size(); i < size; i++){
            MenuInfo menuInfo = menuInfoList.get(i);
            sb.append("<li>");
            sb.append("<a href=\"#\">");
            sb.append("<i class=\"fa fa fa-bar-chart-o\"></i>");
            sb.append("<span class=\"nav-label\">" + menuInfo.getName() + "</span>");
            sb.append("<span class=\"fa arrow\"></span>");
            sb.append("</a>");
            /**
            *           <li>
             <a class="J_menuItem" href="layouts.html"><i class="fa fa-columns"></i> <span class="nav-label">布局</span></a>
             </li>
             * */


            sb.append("<ul class=\"nav nav-second-level\">");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_echarts.html\">百度ECharts</a>");
            sb.append("</li>");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_flot.html\">Flot</a>");
            sb.append("</li>");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_morris.html\">Morris.js</a>");
            sb.append("</li>");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_rickshaw.html\">Rickshaw</a>");
            sb.append("</li>");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_peity.html\">Peity</a>");
            sb.append("</li>");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_sparkline.html\">Sparkline</a>");
            sb.append("</li>");
            sb.append("<li>");
            sb.append("<a class=\"J_menuItem\" href=\"graph_metrics.html\">图表组合</a>");
            sb.append("</li>");
            sb.append("</ul>");
            sb.append("</li>");
        }
        return sb.toString();
    }




}
