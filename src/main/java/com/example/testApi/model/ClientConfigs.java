package com.example.testApi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "chdl_cdc_client_configs")
public class ClientConfigs {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(name = "client_name")
        private String clientName;
        @Column(name = "createdby")
        private String createdby;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "createddate", insertable=false)
        private Date createddate;
        @Column(name = "client_msk_brokers")
        private String clientmskbrokers;

        @Column(name = "client_kafka_connect_url")
        private String clientKafkaCOnnectUrl;

        public Date getCreateddate() {
            return createddate;
        }

        public void setCreateddate(Date createddate) {
            this.createddate = createddate;
        }

        @Column(name = "is_active")
        private int isActive;

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientmskbrokers() {
            return clientmskbrokers;
        }

        public void setClientmskbrokers(String clientmskbrokers) {
            this.clientmskbrokers = clientmskbrokers;
        }

        public String getClientKafkaCOnnectUrl() {
            return clientKafkaCOnnectUrl;
        }

        public void setClientKafkaCOnnectUrl(String clientKafkaCOnnectUrl) {
            this.clientKafkaCOnnectUrl = clientKafkaCOnnectUrl;
        }

        public String getCreatedby() {
            return createdby;
        }

        public void setCreatedby(String createdby) {
            this.createdby = createdby;
        }

        public int isActive() {
            return isActive;
        }

        public void setActive(int active) {
            isActive = active;
        }


}
