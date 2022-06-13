package com.example.demo.api.VO.City;

import lombok.Data;

@Data
public class CityVO {

    private String cid;

    private String pid;

    private int population;

    private int happy_index;

    private int eco_elec_energy_index;

    private int non_elec_energy_index;

    private int oil_energy_index;

    private int envi_score;

    private int water_envi_score;

    private int air_envi_score;

    private int soil_envi_score;

    private int duty_tax_rate;

    private int income_tax_rate;

    private int donation_total;

    private int ranking;

    private int oil_traffic_score;

    private int elec_traffic_score;

    private int subsidy_score;

    private int import_total;

    private int export_total;


}
