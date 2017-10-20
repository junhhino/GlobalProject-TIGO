/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.lothar.portabilityprocessasoc.entities;

/**
 *
 * @author expaae
 */
public class ProcesoTipoProceso {

    private Long proceso;
    private Long tipo_proceso;
    private String nombreInvocacion;
    private String paramsEntrada;
    private String paramsSalida;
    private String paramsConnection;
    private String codigoProceso;
            
    public ProcesoTipoProceso() {

    }

    /**
     * @return the proceso
     */
    public Long getProceso() {
        return proceso;
    }

    /**
     * @param proceso the proceso to set
     */
    public void setProceso(Long proceso) {
        this.proceso = proceso;
    }

    /**
     * @return the tipo_proceso
     */
    public Long getTipo_proceso() {
        return tipo_proceso;
    }

    /**
     * @param tipo_proceso the tipo_proceso to set
     */
    public void setTipo_proceso(Long tipo_proceso) {
        this.tipo_proceso = tipo_proceso;
    }

    /**
     * @return the nombreInvocacion
     */
    public String getNombreInvocacion() {
        return nombreInvocacion;
    }

    /**
     * @param nombreInvocacion the nombreInvocacion to set
     */
    public void setNombreInvocacion(String nombreInvocacion) {
        this.nombreInvocacion = nombreInvocacion;
    }

    /**
     * @return the paramsEntrada
     */
    public String getParamsEntrada() {
        return paramsEntrada;
    }

    /**
     * @param paramsEntrada the paramsEntrada to set
     */
    public void setParamsEntrada(String paramsEntrada) {
        this.paramsEntrada = paramsEntrada;
    }

    /**
     * @return the paramsSalida
     */
    public String getParamsSalida() {
        return paramsSalida;
    }

    /**
     * @param paramsSalida the paramsSalida to set
     */
    public void setParamsSalida(String paramsSalida) {
        this.paramsSalida = paramsSalida;
    }

    /**
     * @return the paramsConnection
     */
    public String getParamsConnection() {
        return paramsConnection;
    }

    /**
     * @param paramsConnection the paramsConnection to set
     */
    public void setParamsConnection(String paramsConnection) {
        this.paramsConnection = paramsConnection;
    }

    /**
     * @return the codigoProceso
     */
    public String getCodigoProceso() {
        return codigoProceso;
    }

    /**
     * @param codigoProceso the codigoProceso to set
     */
    public void setCodigoProceso(String codigoProceso) {
        this.codigoProceso = codigoProceso;
    }

}
