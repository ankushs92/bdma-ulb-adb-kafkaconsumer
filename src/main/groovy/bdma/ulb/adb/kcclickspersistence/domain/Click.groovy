package bdma.ulb.adb.kcclickspersistence.domain

import bdma.ulb.adb.kcclickspersistence.jackson.LocalDateTimeDeserializer

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import groovy.transform.ToString
import org.springframework.cassandra.core.PrimaryKeyType
import org.springframework.data.cassandra.mapping.Column
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.mapping.Table

import java.time.LocalDateTime

@ToString(includeNames = true)
@Table("clicks")
class Click {

    @JsonProperty("uid")
    @PrimaryKeyColumn(value = "uuid", type = PrimaryKeyType.PARTITIONED)
    final UUID uid

    @JsonDeserialize(using = LocalDateTimeDeserializer)
    @JsonProperty("timestamp")
    @Column(value = "timestamp")
    final LocalDateTime timestamp

    @JsonProperty("campaignId")
    @Column(value = "campaign_id")
    final Integer campaignId

    @JsonProperty("pubId")
    @Column(value = "pub_id")
    final Integer pubId

    @JsonProperty(value="ip")
    @Column(value = "ip")
    final  String ip

    @JsonProperty(value='city',required=false , defaultValue =  '')
    @Column(value = "city")
    final String city

    @JsonProperty(value='country',required=false , defaultValue =  '')
    @Column(value = "country")
    final String country

    @JsonProperty(value='browser',required=false , defaultValue =  '')
    @Column(value = "browser")
    final String browser

    @JsonProperty(value='platform',required=false , defaultValue =  '')
    @Column(value = "platform")
    final String platform

    @JsonProperty(value='platformVersion',required=false , defaultValue =  '')
    @Column(value = "platform_ver")
    final String platformVersion


}
