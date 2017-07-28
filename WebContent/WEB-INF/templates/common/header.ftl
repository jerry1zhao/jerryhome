<header>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                    <span class="sr-only"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                </button>
                <a href="posts" class="logo"></a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right pull-right">
                    <li>
                        <div class="input-group navbar-search">
                            <input id="inputSearch" type="text"
                                class="form-control navbar-search-text" /> <a id="search"
                                href="" class="input-group-addon navbar-search-img"> <span
                                class="glyphicon glyphicon-search"></span>
                            </a>
                        </div>
                    </li>
                    <li><a class="writing" href="post/editor"> <span
                            class="glyphicon glyphicon-pencil"></span></a>
                    </li><#if user?exists>
                    <!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
                        data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false"><img src="${user.photo}"
                            class="img-circle user-avatar"></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">个人主页</a></li>
                            <li><a href="#">账号设置</a></li>
                            <li><a href="#">消息</a></li>
                            <li><a href="#">反馈</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">退出</a></li>
                        </ul></li> -->
                    <li class="am-dropdown" data-am-dropdown><a
                        class="am-dropdown-toggle" data-am-dropdown-toggle
                        href="javascript:;"><img src="${user.photo}"
                            class="img-circle user-avatar"> </a>
                        <ul class="am-dropdown-content">
                            <li class="am-dropdown-header">${user.name}</li>
                            <li><a href="#">个人主页</a></li>
                            <li><a href="#">账号设置</a></li>
                            <li><a href="#">消息</a></li>
                            <li><a href="#">反馈</a></li>
                            <li class="am-divider"></li>
                            <li><a href="logout">退出</a></li>
                        </ul></li> <#else>
                    <li><a href="logon" class="btn-login">登录</a></li> </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>
