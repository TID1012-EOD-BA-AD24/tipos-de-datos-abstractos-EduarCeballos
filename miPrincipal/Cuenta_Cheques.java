package miPrincipal;

public class Cuenta_Cheques {
   //coloca el codigo faltante
   public String nombreCuenta;
   public String nombreCliente;
   public String sucursal;
   public float saldo;

   
   public String getNombreCuenta() {
      return nombreCuenta;
   }
   public void setNombreCuenta(String nombreCuenta) {
      this.nombreCuenta = nombreCuenta;
   }
   public String getNombreCliente() {
      return nombreCliente;
   }
   public void setNombreCliente(String nombreCliente) {
      this.nombreCliente = nombreCliente;
   }
   public String getSucursal() {
      return sucursal;
   }
   public void setSucursal(String sucursal) {
      this.sucursal = sucursal;
   }
   public float getSaldo() {
      return saldo;
   }
   public Cuenta_Cheques(){
      this.nombreCliente = "";
      this.nombreCuenta = "";
      this.sucursal = "";
      this.saldo = 0;

   }
public Cuenta_Cheques(String nombreCuenta, String nombreCliente, String sucursal, float saldo) {
    this.nombreCuenta = nombreCuenta;
    this.nombreCliente = nombreCliente;
    this.sucursal = sucursal;
    this.saldo = saldo;
}
   

   
    
    
}
