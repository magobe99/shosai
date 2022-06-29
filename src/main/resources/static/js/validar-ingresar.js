function entrar(){
    var ingreso = document.getElementById('ingreso').value;
    var seguridad = document.getElementById("seguridad").value;
            
    if(ingreso === "" || seguridad === ""){
        swal("Eror!", "Completa todos los campos!", "error"); 
    }else{
       swal("BIENVENIDO!", "ingresaste con tu cuenta!", "success");
    }
}  

