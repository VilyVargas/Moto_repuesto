package Modelo;

public class DetalleCompra {
    private int ID_Detalle_Com;
    private int ID_Compra;
    private int ID_Producto;
    private int Cantidad_com;
    private float Precio_Com;

    public DetalleCompra(int ID_Detalle_Com, int ID_Compra, int ID_Producto, int Cantidad_com, float Precio_Com) {
        this.ID_Detalle_Com = ID_Detalle_Com;
        this.ID_Compra = ID_Compra;
        this.ID_Producto = ID_Producto;
        this.Cantidad_com = Cantidad_com;
        this.Precio_Com = Precio_Com;
    }

    public DetalleCompra() {
    }

    public int getID_Detalle_Com() {
        return ID_Detalle_Com;
    }

    public void setID_Detalle_Com(int ID_Detalle_Com) {
        this.ID_Detalle_Com = ID_Detalle_Com;
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getCantidad_com() {
        return Cantidad_com;
    }

    public void setCantidad_com(int Cantidad_com) {
        this.Cantidad_com = Cantidad_com;
    }

    public float getPrecio_Com() {
        return Precio_Com;
    }

    public void setPrecio_Com(float Precio_Com) {
        this.Precio_Com = Precio_Com;
    }

}
