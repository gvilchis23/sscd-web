/**
 * Proyecto: IMSS  - SSDC
 *
 * Archivo: PdcForm.java
 *
 * Creado: 11/10/2011
 *
 * Derechos Reservados de copia (c) - INAP /
 *
 * Instituto Mexicano del Seguro Social - 2011
 */

package mx.gob.imss.cia.ssdc.cdv.presentacion.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.stereotype.Component;

/**
 * @author Leandro Ortiz I.
 *
 */
@Component
public class PdcForm {
    /**
     * Variable local para guardar la ruta de la imagen del reporte.
     */
    private String imgReporte = "";

    /**
     * Variable local para guardar el tipo de carga pero para los filtros.
     */
    private String tipoC;

    /**
     * Variable local para guardar el tipo de carga.
     */
    private String tipo;

    /**
     * Variable local para guardar el tipo de carga en nuevo proceso.
     */
    private String tipoNuevo;

    /**
     * Variable local para guardar el mes de los filtros.
     */
    private String mes;

    /**
     * Variable local para guardar el anio de los filtros.
     */
    private String anio;

    /**
     * Variable local para guardar el anio de nuevo proceso.
     */
    private String anioNuevo;

    /**
     * Variable local para guardar la fecha inicial de periodo.
     */
    private Date fechaIni;

    /**
     * Variable local para guardar la fecha final de periodo.
     */
    private Date fechaFinal;

    /**
     * Variable local para guardar la descripcion del periodo.
     */
    private String descripcion;

    /**
    *
    */
    private String estatus;

    /**
     * Variable local para guardar num. dias inhabiles periodo.
     */
    private String numDiasInhab;

    /**
     * Variable local para guardar la lista del combo de tipo de carga.
     */
    private List<SelectItem> comboTipo = new ArrayList<SelectItem>();

    /**
     * Variable local para guardar la lista del combo de meses.
     */
    private List<SelectItem> comboMes = new ArrayList<SelectItem>();

    /**
     * Variable local para guardar la lista del combo anios.
     */
    private List<SelectItem> comboAnio = new ArrayList<SelectItem>();

    /**
     * Variable local para guardar la lista del combo anios
     * para Nuevo Proceso de Carga.
     */
    private List<SelectItem> comboAnioNuevoPC = new ArrayList<SelectItem>();

    /**
     * Variable local para guardar la lista del combo estatus.
     */
    private List<SelectItem> comboEstatus = new ArrayList<SelectItem>();

    /**
     * Variable local para guardar la lista de cvds.
     */
    private List<SelectItem> listaCdvs = new ArrayList<SelectItem>();

    /**
     * Variable local para guardar la lista de cdvs seleccionadas.
     */
    private List<SelectItem> listaCdvsSeleccionadas =
                   new ArrayList<SelectItem>();

    /**
     * Variable local para guardar el Id del proceso de carga.
     */
    private Long id;

    /**
   * Variable local para guardar el nombre o descrip. en
   * el listado de procesos de carga.
    */
    private String nombre;

    /**
    * Variable local para guardar la fecha del proceso de
    * carga en el listado de procesos de carga.
    */
    private String fecha;

    /**
     * Variable local para guardar el Id del dia inhabil.
     */
    private Long idFechaInhabil;

    /**
     * Variable local para guardar la fecha festiva
     * en el listado de dias inhabiles.
     */
    private String fechaInhabilListado;

    /**
     * Variable local para guardar la descripcion de la
     * fecha inhabil o dias festivo en el listado de dias
     * inhabiles.
     */
    private String descripFechaInhabilListado;

    /**
     * Devuelve el tipo de carga.
     *
     * @return tipo de carga
     *
     */
    public final String getTipoC() {
        return tipoC;
    }

    /**
     * Guarda el tipo de carga.
     *
     * @param tipoAux de proceso de carga
     */
    public final void setTipoC(final String tipoAux) {
        this.tipoC = tipoAux;
    }

    /**
     * Devuelve el tipo de carga.
     *
     * @return tipo de carga
     *
     */
    public final String getTipo() {
        return tipo;
    }

    /**
     * Guarda el tipo de carga.
     *
     * @param tipoCar
     *            de proceso de carga
     */
    public final void setTipo(final String tipoCar) {
        this.tipo = tipoCar;
    }

    /**
     * Devuelve el tipo de carga para nuevo proc.
     *
     * @return el tipo de carga
     */
    public final String getTipoNuevo() {
        return tipoNuevo;
    }

    /**
     * Guarda el tipo de carga para nuevo proc.
     *
     * @param tipoNuevoCar
     *            tipo de carga
     */
    public final void setTipoNuevo(final String tipoNuevoCar) {
        this.tipoNuevo = tipoNuevoCar;
    }

    /**
     * Devuelve el Mes.
     *
     * @return el mes
     */
    public final String getMes() {
        return mes;
    }

    /**
     * Guarda el Mes.
     *
     * @param mesAux recibe el numero de mes
     */
    public final void setMes(final String mesAux) {
        this.mes = mesAux;
    }

    /**
     * Devuelve el anio.
     *
     * @return el anio
     */
    public final String getAnio() {
        return anio;
    }

    /**
     * Guarda el anio.
     *
     * @param anioAux el anio del proceso de carga
     */
    public final void setAnio(final String anioAux) {
        this.anio = anioAux;
    }

    /**
     * Devuelve el anio para nuevo proc.
     *
     * @return el anio para nuevo proceso
     */
    public final String getAnioNuevo() {
        return anioNuevo;
    }

    /**
     * Guarda el anio para nuevo proc.
     *
     * @param anioNuevoAux el anio para nuevo proceso
     */
    public final void setAnioNuevo(final String anioNuevoAux) {
        this.anioNuevo = anioNuevoAux;
    }

    /**
     * Devuelve la fecha inicial de periodo.
     *
     * @return la fecha inicial
     */
    public final Date getFechaIni() {
        return fechaIni;
    }

    /**
     * Guarda la fecha inicial de periodo.
     *
     * @param fechaIniAux la fecha inicial
     */
    public final void setFechaIni(final Date fechaIniAux) {
        this.fechaIni = fechaIniAux;
    }

    /**
     * Devuelve la fecha final de periodo.
     *
     * @return fechaFinal proceso de carga
     */
    public final Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Guarda la fecha final de periodo.
     *
     * @param fechaFinalAux proceso de carga
     */
    public final void setFechaFinal(final Date fechaFinalAux) {
        this.fechaFinal = fechaFinalAux;
    }

    /**
     * Devuelve la descripcion del periodo.
     *
     * @return la descripcion del proceso
     */
    public final String getDescripcion() {
        return descripcion;
    }

    /**
     * Guarda la descripcion del periodo.
     *
     * @param descripcionAux del proceso de carga
     */
    public final void setDescripcion(final String descripcionAux) {
        this.descripcion = descripcionAux;
    }

    /**
     *
     * @return el estatus del proceso de carga
     */
    public final String getEstatus() {
        return estatus;
    }

    /**
     *
     * @param estatusAux del proceso de carga
     */
    public final void setEstatus(final String estatusAux) {
        this.estatus = estatusAux;
    }

    /**
     * Devuelve el numero de dias inhabiles del periodo.
     *
     * @return el numero de dias inhabiles
     */
    public final String getNumDiasInhab() {
        return numDiasInhab;
    }

    /**
     * Guarda el numero de dias inhabiles del periodo.
     *
     * @param numDiasInhabAux del periodo de carga
     */
    public final void setNumDiasInhab(final String numDiasInhabAux) {
        this.numDiasInhab = numDiasInhabAux;
    }

    /**
     * Devuelve la ruta de la imagen para reporte.
     *
     * @return retorna la ruta de la imagen
     */
    public final String getImgReporte() {
        return imgReporte;
    }

    /**
     * Guarda la ruta de la imagen para reporte.
     *
     * @param imgReporteAux Recibe la ruta de la imagen
     */
    public final void setImgReporte(final String imgReporteAux) {
        this.imgReporte = imgReporteAux;
    }

    /**
     * Devuelve el Id del proceso de carga.
     *
     * @return Retorna el id del proceso de carga
     */
    public final Long getId() {
        return id;
    }

    /**
     * Guarda el Id del proceso de carga.
     *
     * @param i id del proceso de carga
     *
     */
    public final void setId(final long i) {
        this.id = i;
    }

    /**
     * Devuelve el nombre.
     *
     * @return Retorna el nombre o descripcion del proceso
     * de carga.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Guarda el nombre.
     *
     * @param nombreAux Recibe el nombre o descrip. del proceso
     * de carga.
     */
    public final void setNombre(final String nombreAux) {
        this.nombre = nombreAux;
    }

    /**
     * Devuelve la fecha.
     *
     * @return Retorna la fecha
     */
    public final String getFecha() {
        return fecha;
    }

    /**
     * Guarda la fecha.
     *
     * @param fechaAux Recibe la fecha
     */
    public final void setFecha(final String fechaAux) {
        this.fecha = fechaAux;
    }

    /**
     * Devuelve el id de la fecha inhabil en el listado
     * de dias inhabiles.
     * @return id de fecha festiva o inhabil.
     */
    public final Long getIdFechaInhabil() {
        return idFechaInhabil;
    }

    /**
     * Guarda el id de la fecha inhabil de el listado de
     * dias inhabiles.
     * @param idFechaInhabilAux Recibe el id la fecha inhabil.
     */
    public final void setIdFechaInhabil(
                      final Long idFechaInhabilAux) {
        this.idFechaInhabil = idFechaInhabilAux;
    }

    /**
     * Devuelve la fecha inhabil en el listado
     * de dias inhabiles.
     * @return fecha festiva o inhabil.
     */
    public final String getFechaInhabilListado() {
        return fechaInhabilListado;
    }

    /**
     * Guarda la fecha inhabil de el listado de
     * dias inhabiles.
     * @param fechaInhabilListadoAux Recibe la fecha inhabil.
     */
    public final void setFechaInhabilListado(
                      final String fechaInhabilListadoAux) {
        this.fechaInhabilListado = fechaInhabilListadoAux;
    }

    /**
     * Devuelve la descripcion de la fecha inhabil en el listado
     * de dias inhabiles.
     * @return Retorna la descripcion
     */
    public final String getDescripFechaInhabilListado() {
        return descripFechaInhabilListado;
    }

    /**
     * Guarda la descripcion de la efcha inhabil en el listado de
     * de dias inhabiles.
     * @param descripFechaInhabilListadoAux Recibe la descripcion
     */
    public final void setDescripFechaInhabilListado(
                    final String descripFechaInhabilListadoAux) {
        descripFechaInhabilListado = descripFechaInhabilListadoAux;
    }

    /**
     * Devuelve la lista de tipos de carga.
     *
     * @return Retorna el combo de tipo de proceso
     * de carga.
     */
    public final List<SelectItem> getComboTipo() {
        return comboTipo;
    }

    /**
     * Guarda la lista de tipos de carga.
     *
     * @param comboTipoAux Recibe el combo de tipo de
     * proceso de carga.
     */
    public final void setComboTipo(final List<SelectItem> comboTipoAux) {
        this.comboTipo = comboTipoAux;
    }

    /**
     * Devuelve la lista de meses.
     *
     * @return Retorna el commbo del mes.
     */
    public final List<SelectItem> getComboMes() {
        return comboMes;
    }

    /**
     * Guarda la lista de meses.
     *
     * @param comboMesAux Recibe el combo de mes.
     */
    public final void setComboMes(final List<SelectItem> comboMesAux) {
        this.comboMes = comboMesAux;
    }

    /**
     * Devuelve la lista de anios.
     *
     * @return Retorna el combio de anios
     */
    public final List<SelectItem> getComboAnio() {
        return comboAnio;
    }

    /**
     * Guarda la lista de anios.
     *
     * @param comboAnioAux Recibe el combo de anios.
     */
    public final void setComboAnio(final List<SelectItem> comboAnioAux) {
        this.comboAnio = comboAnioAux;
    }

    /**
     * Devuelve la lista de anios.
     * @return Retorna el combo de anios
     */
    public final List<SelectItem> getComboAnioNuevoPC() {
        return comboAnioNuevoPC;
    }

    /**
     * Guarda la lista de anios.
     * @param comboAnioNuevoPCAux Recibe el combo de anios.
     */
    public final void setComboAnioNuevoPC(
                     final List<SelectItem> comboAnioNuevoPCAux) {
        this.comboAnioNuevoPC = comboAnioNuevoPCAux;
    }

    /**
     * Devuelve la lista de estatus.
     *
     * @return Retorna el combo de estatus
     */
    public final List<SelectItem> getComboEstatus() {
        return comboEstatus;
    }

    /**
     * Guarda la lista de estatus.
     *
     * @param comboEstatusAux Recibe el combo de estatus
     */
    public final void setComboEstatus(final List<SelectItem> comboEstatusAux) {
        this.comboEstatus = comboEstatusAux;
    }

    /**
     * Devuelve la lista de cvds.
     * @return Retorna la lista de cvds
     */
    public final List<SelectItem> getListaCdvs() {
        return listaCdvs;
    }

    /**
     * Guarda la lista de cdvs.
     * 
     * @param listaCdvsAux Recibe la lista de cdvs
     */
    public final void setListaCdvs(final List<SelectItem> listaCdvsAux) {
        this.listaCdvs = listaCdvsAux;
    }

    /**
     * Devuelve la lista de cvds seleccionadas.
     * @return Retorna la lista de cvds seleccionadas
     */
    public final List<SelectItem> getListaCdvsSeleccionadas() {
        return listaCdvsSeleccionadas;
    }

    /**
     * Guarda la lista de cdvs seleccionadas.
     * @param listaCdvsSeleccionadasAux Recibe la lista de cdvs seleccionadas
     */
    public final void setListaCdvsSeleccionadas(
                      final List<SelectItem> listaCdvsSeleccionadasAux) {
        this.listaCdvsSeleccionadas = listaCdvsSeleccionadasAux;
    }

}
