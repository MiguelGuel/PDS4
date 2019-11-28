/*,
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author LENOVO
 */
public class orden {
    String id, idc, fecha, desc;

    public String getId() {
        return id;
    }

    public String getIdc() {
        return idc;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDesc() {
        return desc;
    }

    public orden(String id, String idc, String fecha, String desc) {
        this.id = id;
        this.idc = idc;
        this.fecha = fecha;
        this.desc = desc;
    }
}
