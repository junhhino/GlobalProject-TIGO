package py.com.lothar.portabilityprocessasoc.utils;

/**
 *
 * @author expaae
 */
public class Constantes {

    //Estados de las transacciones
    public static final long TRANS_ESTADO_CARGANDO = 1;
    public static final long TRANS_ESTADO_PENDIENTE = 2;
    public static final long TRANS_ESTADO_EJECUCION = 3;
    public static final long TRANS_ESTADO_OK = 4;
    public static final long TRANS_ESTADO_ERROR = 5;
    public static final long TRANS_ESTADO_ERROR_PARCIAL = 6;
    public static final long TRANS_ESTADO_ERROR_RESPUESTA = 7;
    
    //Estado de la respuesta PLEX
    public static final String PLEX_EXECUTION_OK = "0";

    //Tipo de Proceso
    public static final long TIPO_PROCESO_PLEX = 1;
    public static final long TIPO_PROCESO_STORE_PROCEDURE = 2;

    //ATRIBUTOS DE p_transacciones
    public static final String P_TRX_ID_TRANSACCION = "ID_TRANSACCION";
    public static final String P_TRX_EXTERNAL_TRANSACTION_ID = "EXTERNAL_TRANSACTION_ID";
    public static final String P_TRX_CODIGO_PROCESO = "CODIGO_PROCESO";
    public static final String P_TRX_FECHA_HORA_ALTA = "FECHA_HORA_ALTA";
    public static final String P_TRX_FECHA_HORA_INIT = "FECHA_HORA_INIT";
    public static final String P_TRX_FECHA_HORA_FIN = "FECHA_HORA_FIN";
    public static final String P_TRX_ESTADO_PROCESO_ID = "ESTADO_PROCESO_ID";
    public static final String P_TRX_TIPO_INBOUND_ID = "TIPO_INBOUND_ID";
    public static final String P_TRX_ARCHIVO_FTP_ID = "ARCHIVO_FTP_ID";

    //Atribitps de P_TRANSACCIONES_CUENTAS
    public static final String P_TRX_CTA_ID = "ID";
    public static final String P_TRX_CTA_NRO_CUENTA = "NRO_CUENTA";
    public static final String P_TRX_CTA_FECHA_HORA_ALTA = "FECHA_HORA_ALTA";
    public static final String P_TRX_CTA_ESTADO_PROCESO_ID = "ESTADO_PROCESO_ID";
    public static final String P_TRX_CTA_ID_TRANSACCION = "ID_TRANSACCION";
    public static final String P_TRX_CTA_FECHA_HORA_INIT = "FECHA_HORA_INIT";
    public static final String P_TRX_CTA_FECHA_HORA_FIN = "FECHA_HORA_FIN";
    public static final String P_TRX_CTA_COD_RESPUESTA = "COD_RESPUESTA";
    public static final String P_TRX_CTA_MENSAJE_RESPUESTA = "MENSAJE_RESPUESTA";
    public static final String P_TRX_CTA_RESP_ESTADO = "RESP_ESTADO";
    
    //Atributos de P_PROCESO_TIPO_PROCESO
    public static final String PROCESO_PROCESO = "PROCESO";
    public static final String PROCESO_TIPO_PROCESO = "TIPO_PROCESO";
    public static final String PROCESO_NOMBRE_INVOCACION = "NOMBRE_INVOCACION";
    public static final String PROCESO_PARAMS_ENTRADA = "PARAMS_ENTRADA";
    public static final String PROCESO_PARAMS_SALIDA = "PARAMS_SALIDA";
    public static final String PROCESO_PARAMS_CONNECTION = "PARAMS_CONNECTION";
    public static final String PROCESO_CODIGO_PROCESO = "CODIGO_PROCESO";

}
