
function confirm(){
    let nombre = document.getElementById("nombre");
    let apellidos = document.getElementById("apellidos");
    let telefono = document.getElementById("telefono");
    let correo = document.getElementById("correo");
    let identificacion = document.getElementById("identificacion"); 
    let edad = document.getElementById("edad");
    let fecha = document.getElementById("fecha");
    let clave = document.getElementById("clave");
        
    if( nombre.value === "" || apellidos.value === "" ||  correo.value === "" ||
             identificacion.value === "" ||  edad.value === "" ||  fecha.value === "" ||  clave.value === ""  ){
    swal("Error!", "Completa todos los campos!", "error");    
    }
    else {
       swal("REGISTRADO!", "creaste una cuenta!", "success");
  
    }
    
}
