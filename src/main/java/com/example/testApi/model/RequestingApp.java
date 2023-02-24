package com.example.testApi.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chdl_cdc_requesting_application_details")
public class RequestingApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "requesting_application_name")
    private String requestingApplicationName;
    @Column(name = "createdby")
    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createddate", insertable=false)
    private Date createddate;
    @Column(name="db_credentionals_configured")
    private int dbCredentionalsConfigured;

    public RequestingApp() {
    }

    public RequestingApp(long id, String requestingApplicationName, String createdBy, Date createddate, int dbCredentionalsConfigured, int isActive) {
        this.id = id;
        this.requestingApplicationName = requestingApplicationName;
        this.createdBy = createdBy;
        this.createddate = createddate;
        this.dbCredentionalsConfigured = dbCredentionalsConfigured;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestingApplicationName() {
        return requestingApplicationName;
    }

    public void setRequestingApplicationName(String requestingApplicationName) {
        this.requestingApplicationName = requestingApplicationName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public int getDbCredentionalsConfigured() {
        return dbCredentionalsConfigured;
    }

    public void setDbCredentionalsConfigured(int dbCredentionalsConfigured) {
        this.dbCredentionalsConfigured = dbCredentionalsConfigured;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Column(name="is_active")
    private int isActive;

}
