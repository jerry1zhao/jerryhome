$(function() {
    var postEditor = editormd("postEditor", {
        width : "100%",
        height : 640,
        syncScrolling : "single",
        path : "../editormd/lib/",
        saveHTMLToTextarea : true,
        imageUpload : true,
        imageFormats : ["jpg", "jpeg", "gif", "png"],
        imageUploadURL : "uploadContentImage",
        toolbarIcons : function() {
            // Or return editormd.toolbarModes[name]; // full, simple, mini
            // Using "||" set icons align right.
            return ["undo", "redo", "|",
                    "bold" ,"italic", "quote", "|",
                    "h1", "h2", "h3", "h4", "h5", "h6", "|",
                    "list-ul", "list-ol", "hr", "|",
                    "link", "reference-link", "image", "code", "code-block", "table", "pagebreak", "|",
                    "goto-line", "watch", "preview", "fullscreen", "clear", "search", "|",
                    "help"]
        }
    });

    initFileUpload();

    $("#commitPost").click(function(){
//        alert(editor.getMarkdown());
//        alert(editor.getHTML());
        commitPost();
    });

    //	$("#postImage").on('fileuploaderror', function(event, data, previewId, index)
    //	{
    //	var form = data.form, files = data.files, extra = data.extra,
    //	response = data.response, reader = data.reader;
    //	console.log(data);
    //	console.log('File upload error');
    //	});

    //	$("#postImage").on('fileerror', function(event, data) {
    //	console.log(data.id);
    //	console.log(data.index);
    //	console.log(data.file);
    //	console.log(data.reader);
    //	console.log(data.files);
    //	});

    //	$("#postImage").on('fileuploaded', function(event, data, previewId, index) {
    //	var form = data.form, files = data.files, extra = data.extra,
    //	response = data.response, reader = data.reader;
    //	console.log('File uploaded triggered');
    //	});
});

function initFileUpload() {
    $("#postImage").fileinput({
        language : 'zh',
        fileTypeSettings : [ "image" ],
        allowedPreviewTypes : [ 'image' ],
        allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
        maxFileSize : 2048,
        maxFileCount : 1,
        showCaption : false,
        dropZoneEnabled : false,
        uploadAsync : false,
        showUpload : false
    });
}

function commitPost() {
    if ($('#postImage').fileinput("getFilesCount") <= 0) {
        alert("请上传一张帖子主图片!");
        return;
    }
//    $.post("savePost", $("#postForm").serialize(), function(result){
//        $('#postImage').fileinput('upload');
//    })
    $("#postForm").attr('action', 'savePost');
    $("#postForm").ajaxSubmit({
        success : function(data) {
            $('#postImage').fileinput('upload');
        }
    });
    return false;
}









