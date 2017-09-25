<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>${post.title}</title>
<!-- Bootstrap -->
<link href="../amazeui/css/amazeui.min.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/post.css" rel="stylesheet">
<link href="../css/navbar.css" rel="stylesheet">
</head>
<body>
    <#include "../common/header.ftl">
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-8 col-md-offset-2">
                        <article class="post">
                            <input type="hidden" id="postId" value="${post.id?c}" /> <#if
                            post.postImage??> <img src="${post.postImage}"
                                class="post-head-image"> </#if>
                            <h1 class="title">${post.title}</h1>
                            <div class="author">
                                <a class="username"><img src="${post.createUser.photo}"
                                    class="img-circle user-avatar"> ${post.createUser.name} </a> <span>
                                    <#if (post.createDate)?string("yyyy") == .now?string("yyyy")>
                                    ${post.createDate?string("MM月dd日 HH:mm")} <#else>
                                    ${post.createDate?string("yyyy年MM月dd日 HH:mm")} </#if> </span>
                            </div>
                            <div class="content">${post.htmlContent}</div>
                        </article>
                        <div class="tags">
                            <#list postTags as tag>
                            <h4>
                                <span class="label label-default"><a href="#">#
                                        ${tag}</a></span>
                            </h4>
                            </#list>
                        </div>
                        <hr>
                        <div class="interact">
                        	<#if isLikePost == "notLike">
                        		<a id="likePost" href="javascript:;">喜欢</a>
                        	<#elseif isLikePost == "like">
		                        <a id="likePost" href="javascript:;" class="liked">已喜欢</a>
		                    <#elseif isLikePost == "disLike">
		                        <a id="likePost" href="javascript:;">喜欢</a>
                            </#if>
                        </div>
                        <#if user?exists>
                        <hr>
                        <div class="comment">
                            <form>
                                <div class="col-md-1">
                                    <img src="${user.photo}" class="img-circle user-avatar">
                                </div>
                                <div class="col-md-11">
                                    <textarea class="form-control" rows="3"></textarea>
                                </div>
                                <div class="col-md-12 col-btn-comment">
                                    <button
                                        class="am-btn am-btn-primary am-btn-sm pull-right btn-comment">评论</button>
                                </div>
                            </form>
                        </div>
                        </#if>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="bottom-float-edit">
        <div class="container">
            <div class="row">
                <div class="col-md-11">
                    <button type="button" name="closeBottomEditRow"
                        class="close-bottom-edit-row pull-right">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </button>
                    <input type="button" id="editPost" name="editPost" value="编辑"
                        class="btn-post-edit pull-right" />
                </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.ftl">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../amazeui/js/amazeui.min.js"></script>
    <script src="../js/post.js"></script>
    <script src="../js/search.js"></script>
</body>
</html>
