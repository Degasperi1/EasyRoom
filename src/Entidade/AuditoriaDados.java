/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author evand
 */
@Entity
@Table(name = "audit_log")
public class AuditoriaDados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logid")
    private Integer logid;
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "event_time_utc")
    private String event_time_utc;
    @Column(name = "table_name")
    private String table_name;
    @Column(name = "operation")
    private String operation;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEvent_time_utc() {
        return event_time_utc;
    }

    public void setEvent_time_utc(String event_time_utc) {
        this.event_time_utc = event_time_utc;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getLogid() {
        return logid;
    }

    public void setLogid(Integer logid) {
        this.logid = logid;
    }
    

    @Override
    public String toString() {
        return "userid= " + userid + ", event_time_utc= " + event_time_utc + ", table_name= " + table_name + ", operation= " + operation;
    }

    
}
