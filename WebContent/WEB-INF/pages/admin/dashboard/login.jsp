<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
    
<html class="html" lang="en-US">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/animate.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/style.css">
</head>
<body class="gray-bg">
  <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <h3>Welcome to Mashlahat login screen sad </h3>
            <p>Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
                <!--Continually expanded and constantly improved Inspinia Admin Them (IN+)-->
            </p>  
            <p>Login in. To see it in action.</p>
            <form class="m-t" role="form" action="loginAction" method="post">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Username" required="" name="email">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" required="" name="password">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

            </form>
            <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p>
        </div>
    </div>
  
</body>
</html>