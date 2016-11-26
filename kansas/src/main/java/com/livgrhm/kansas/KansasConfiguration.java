package com.livgrhm.kansas;

import io.dropwizard.Configuration;
//import io.dropwizard.db.DataSourceFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class KansasConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty("smtpServer")
    private String smtpServer = "";

    @NotEmpty
    @JsonProperty("smtpPort")
    private String smtpPort = "";
       
    @NotEmpty
    @JsonProperty("TLS")
    private String TLS = "";

    @NotEmpty
    @JsonProperty("SSL")
    private String SSL = "";

    @NotEmpty
    @JsonProperty("SMTPAuth")
    private String SMTPAuth = "";

    @NotEmpty
    @JsonProperty("emailFrom")
    private String emailFrom = "";

    @NotEmpty
    @JsonProperty("emailUserId")
    private String emailUserId = "";

    @NotEmpty
    @JsonProperty("emailPassword")
    private String emailPassword = "";

    @NotEmpty
    @JsonProperty("systemType")
    private String systemType = "";
    
    @NotEmpty
    @JsonProperty("template")
    private String template = "";
    
    @NotEmpty
    @JsonProperty("defaultName")
    private String defaultName = "";
    
//    @Valid
//    @NotNull
//    @JsonProperty
//    private DataSourceFactory database = new DataSourceFactory();
//
//    public DataSourceFactory getDataSourceFactory() {
//        return getDatabase();
//    }
    
    
    @JsonProperty
    public String getSmtpPort() {
        return smtpPort;
    }

    @JsonProperty
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    @JsonProperty
    public String getSmtpServer() {
        return smtpServer;
    }

    @JsonProperty
    public void setSmtpServer(String smtpServer) {
        this.smtpServer = smtpServer;
    }
    
    /**
     * @return the TLS
     */
    public String getTLS() {
        return TLS;
    }

    /**
     * @param TLS the TLS to set
     */
    public void setTLS(String TLS) {
        this.TLS = TLS;
    }

    /**
     * @return the SSL
     */
    public String getSSL() {
        return SSL;
    }

    /**
     * @param SSL the SSL to set
     */
    public void setSSL(String SSL) {
        this.SSL = SSL;
    }

    /**
     * @return the SMTPAuth
     */
    public String getSMTPAuth() {
        return SMTPAuth;
    }

    /**
     * @param SMTPAuth the SMTPAuth to set
     */
    public void setSMTPAuth(String SMTPAuth) {
        this.SMTPAuth = SMTPAuth;
    }

    /**
     * @return the emailUserId
     */
    public String getEmailUserId() {
        return emailUserId;
    }

    /**
     * @param emailUserId the emailUserId to set
     */
    public void setEmailUserId(String emailUserId) {
        this.emailUserId = emailUserId;
    }

    /**
     * @return the emailPassword
     */
    public String getEmailPassword() {
        return emailPassword;
    }

    /**
     * @param emailPassword the emailPassword to set
     */
    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

//    /**
//     * @return the database
//     */
//    public DataSourceFactory getDatabase() {
//        return database;
//    }
//
//    /**
//     * @param database the database to set
//     */
//    public void setDatabase(DataSourceFactory database) {
//        this.database = database;
//    }

    /**
     * @return the emailFrom
     */
    public String getEmailFrom() {
        return emailFrom;
    }

    /**
     * @param emailFrom the emailFrom to set
     */
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    /**
     * @return the systemType
     */
    public String getSystemType() {
        return systemType;
    }

    /**
     * @param systemType the systemType to set
     */
    public void setSystemType(String systemType) {
        this.systemType = systemType;
    }

    /**
     * @return the template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * @return the defaultName
     */
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * @param defaultName the defaultName to set
     */
    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }
}
