<header>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                    <span class="sr-only"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                </button>
                <a href="https://www.baidu.com" class="logo"></a>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right pull-right">
                    <li>
                        <div class="input-group navbar-search">
                            <input type="text" class="form-control navbar-search-text" /> <span
                                class="input-group-addon navbar-search-img"> <span
                                class="glyphicon glyphicon-search"></span></span>
                        </div>
                    </li>
                    <#if user?exists>
                    <li><a href="#">${user.name}</a></li>
                    <#else>
                    <li><a href="login">登录</a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</header>
