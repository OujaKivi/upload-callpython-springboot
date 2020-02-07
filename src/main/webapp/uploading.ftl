<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>小机灵阅读理解</title>
    </head>

    <body>
        <form name="uploadingForm" enctype="multipart/form-data" action="/" method="POST">
            <p>
                <input id="fileInput" type="file" name="uploadingFiles"  multiple>
<#--                selected files: <span id="fileNum">0</span>;-->
<#--                total size: <span id="fileSize">0</span>-->
            </p>
            <p>
                <input type="submit" value="上传习题图片">
            </p>
        </form>

        <form name="processForm"  action="/process" method="GET">
            <input type="submit" value="获得答案">
        </form>

        <script>
        </script>
    </body>
</html>