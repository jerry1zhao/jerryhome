<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
    content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Jerry Home Edtior</title>
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/editor.css" rel="stylesheet" />
<link href="../css/navbar.css" rel="stylesheet" />
<link href="../editormd/css/style.css" rel="stylesheet" />
<link href="../editormd/css/editormd.css" rel="stylesheet"  />
</head>
<body>
    <#include "../common/header.ftl">
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="editormd" id="test-editormd">
                      <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
                      <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                      <textarea class="editormd-html-textarea" name="text"></textarea>
                    </div>
                 </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.ftl">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../bootstrap/js/bootstrap.min.js"></script>
    <script src="../editormd/js/editormd.min.js"></script>
     <script type="text/javascript">
            var testEditor;

            $(function() {
                testEditor = editormd("test-editormd", {
                    width   : "90%",
                    height  : 640,
                    syncScrolling : "single",
                    path    : "../editormd/lib/"
                    saveHTMLToTextarea : true,
                });

                /*
                // or
                testEditor = editormd({
                    id      : "test-editormd",
                    width   : "90%",
                    height  : 640,
                    path    : "../lib/"
                });
                */
            });
        </script>
</body>
</html>
