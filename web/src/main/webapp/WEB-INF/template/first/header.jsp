<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .menu-one{
        padding: 3px 180px;
    }
    .loading{
        /*position: absolute;*/
        /*z-index: 2;*/
        display:none;
        /*height: 100%;*/
        /*width: 100%;*/
        /*background-color: rgb(200, 200, 201);*/
    }
    #loader{
        position: absolute;
        top:1px;
        left: 15px;
        margin: auto auto;
        height: 24px;
        width: 24px;
    }
    .h-clk{
        background: #ccc;
        border: 1px solid darkgray;
    }

</style>
<header class="h-clk">
    <div class="loading pull-left" >
        <img id="loader" src="${ctx}/resources/img/loading.gif">
    </div>
    <div class="menu-one pull-left">
        <jsp:include page="/WEB-INF/views/usogdp/blocks/static_mainmenu.jsp"/>
    </div>
</header>

