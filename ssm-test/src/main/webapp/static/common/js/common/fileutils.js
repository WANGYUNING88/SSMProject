/**
 * ͷ���ϴ�
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
            show(result.extend.filename,eleImg);
        },
    });
    loading_end();
}

/**
 * չʾͼƬ
 */
function show(filename, ele) {
    if (filename == null || filename.length == 0)
        return;
    $(ele).attr("alt", filename).attr("src", "${APP_PATH}/file/show?filename=" + filename);
    /* $.ajax({
         url: "file/show",
         dataType:"json",
         url:"user/testAjax",
         contentType:"application/json;charset=UTF-8",
         data:'{"username":"��","psd":"123","age":20}',
         dataType:"json",
         type:"POST",
         success:function (result) {
             //result:���������ص�json���ݡ����н���
             alert(result.toString());
         }
     });*/
}