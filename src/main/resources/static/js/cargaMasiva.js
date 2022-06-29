function fileValidation(){
    var fileInput = document.getElementById('campoFile');
    var filePath = fileInput.value;
    var allowedExtensions = /(.csv)$/i;
    if(!allowedExtensions.exec(filePath)){
        alert('Por favor suba un archivo .csv');
        fileInput.value = '';
        return false;
    }else{
        //Image preview
        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('imagePreview').innerHTML = '<img src="'+e.target.result+'"/>';
            };
            reader.readAsDataURL(fileInput.files[0]);
        }
    }
}


