<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Shopping List - Main Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/Resources/css/stylesInterface.css" type="text/css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<head>
    <title>Sidebar4</title>
    <link media="all" type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
</head>

<div class="container-fluid postion-container">
        <div class="row">
            <div class="col-md-3 col-sm-1 sidebar3">

                <div class="name">
                    <p>Krystian</p>
                    <p>12 Contributions</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-2 sidebar4">
                <div class="left-navigation menu-left">
                    <ul>
                        <li ><i class="fa fa-book " aria-hidden="true"></i>Books</li>
                        <li><i class="fa fa-bookmark-o" aria-hidden="true"></i>Active Books <span class="activebooks pull-right">3</span></li>
                        <li><i class="fa fa-trophy" aria-hidden="true"></i>Recommendations</li>
                        <li><i class="fa fa-users" aria-hidden="true"></i>People</li>
                        <li class="list">
                            <div class="dropdown">
                                <i class="fa fa-list" aria-hidden="true"></i>My Wishlist <i class="fa fa-plus pull-right" aria-hidden="true"></i>
                            </div>
                            <ul class="submenu hide">
                                <li>The Sealed Nectar</li>
                                <li>Pride and Prejudice</li>
                                <li>HTML5 for Web Designers</li>
                                <li>The 100, Michael H Heart</li>
                            </ul>
                        </li>
                      </ul>
                        <ul class="category">
                        <li><i class="fa fa-circle-thin" aria-hidden="true"></i>Family Reading</li>
                        <li><i class="fa fa-circle-thin" aria-hidden="true"></i>Education</li>
                        <li><i class="fa fa-circle-thin" aria-hidden="true"></i>Business</li>
                      </ul>
                        <ul>
                        <li><i class="fa fa-cog" aria-hidden="true"></i>Settings</li>
                        <li><i class="fa fa-power-off" aria-hidden="true"></i>Logout</li>
                    </ul>
                </div>
                     
            </div>
           
        </div>
        
    </div>
<script src="${pageContext.request.contextPath}/Resources/js/mainPage.js"></script>
<div id="particles-js"></div>
<script src="${pageContext.request.contextPath}/Resources/js/backgroundShapeMainPage.js"></script>
</body>
</html>