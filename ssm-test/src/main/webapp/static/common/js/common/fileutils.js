/**
 * 头像上传
 */
function upload(eleFile,eleImg) {
    loading_start();
    var formData = new FormData();
    var files = $(eleFile).get(0).files;

    if (files.length == 0)
        return;
    formData.append("fileName", files[0]);
    $.ajax({
        url: "file/upload",
        type: "POST",
        data: formData,
        contentType: false,
        processData: false,
        success: function (result) {
            console.log(result);
            show(result.extend.filename,eleImg);
        },
        error:function () {
            console.log("22");
        }
    });
    loading_end();
}

/**
 * 展示图片
 */
function show(filename, ele) {
    console.log("filename",filename);
    if (filename == null || filename.length == 0) {
        return;
    }
    $(ele).attr("src", ${APP_PATH}+"/file/show?filename=" + filename);
}