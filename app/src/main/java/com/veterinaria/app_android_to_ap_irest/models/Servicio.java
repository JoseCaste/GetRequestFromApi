package com.veterinaria.app_android_to_ap_irest.models;

import java.util.Date;

public class Servicio {
    /*change a little code for view on github */
        private long id;
        private String nombrePerro;
        private String responsable;
        private String servicio;
        private String comentarios;
        private String numTel;
        private double precio;
        private Date fecha;

        private byte []data;



        public Servicio() {

        }

        public Servicio(String nombrePerro, String responsable, String servicio, String comentarios, String numTel,
                         double precio, Date date) {
            this.nombrePerro = nombrePerro;
            this.responsable = responsable;
            this.servicio = servicio;
            this.comentarios = comentarios;
            this.numTel = numTel;
            this.precio = precio;
            this.fecha = date;
        }

        public Servicio(int id, String nombrePerro, String responsable, String servicio, String comentarios, String numTel,
                         double precio, Date fecha) {
            this.id = id;
            this.nombrePerro = nombrePerro;
            this.responsable = responsable;
            this.servicio = servicio;
            this.comentarios = comentarios;
            this.numTel = numTel;
            this.precio = precio;
            this.fecha = fecha;
        }
        public Servicio(int id, String nombrePerro, String responsable, String servicio, String comentarios, String numTel,
                         double precio, Date fecha, byte[]data) {
            this.id = id;
            this.nombrePerro = nombrePerro;
            this.responsable = responsable;
            this.servicio = servicio;
            this.comentarios = comentarios;
            this.numTel = numTel;
            this.precio = precio;
            this.fecha = fecha;
            this.data=data;
        }
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getNombrePerro() {
            return nombrePerro;
        }
        public void setNombrePerro(String nombrePerro) {
            this.nombrePerro = nombrePerro;
        }
        public String getResponsable() {
            return responsable;
        }
        public void setResponsable(String responsable) {
            this.responsable = responsable;
        }
        public String getServicio() {
            return servicio;
        }
        public void setServicio(String servicio) {
            this.servicio = servicio;
        }
        public String getComentarios() {
            return comentarios;
        }
        public void setComentarios(String comentarios) {
            this.comentarios = comentarios;
        }
        public String getNumTel() {
            return numTel;
        }
        public void setNumTel(String numTel) {
            this.numTel = numTel;
        }
        public double getPrecio() {
            return precio;
        }
        public void setPrecio(double precio) {
            this.precio = precio;
        }
        public Date getFecha() {
            return fecha;
        }
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Servicio [id=" + id + ", nombrePerro=" + nombrePerro + ", responsable=" + responsable + ", servicio="
                    + servicio + ", comentarios=" + comentarios + ", numTel=" + numTel + ", precio=" + precio + ", fecha="
                    + fecha + "]";
        }
        /*private int userId;

    private int id;

    private String title;

    private String body;



    public int getUserId() {

        return userId;

    }

    public void setUserId(int userId) {

        this.userId = userId;

    }

    public int getId() {

        return id;

    }

    public void setId(int id) {

        this.id = id;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public String getBody() {

        return body;

    }

    public void setBody(String body) {

        this.body = body;

    }*/


}

