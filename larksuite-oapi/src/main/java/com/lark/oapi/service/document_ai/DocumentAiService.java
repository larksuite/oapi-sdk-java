// Code generated by lark suite oapi sdk gen
/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.lark.oapi.service.document_ai;

import com.lark.oapi.core.Config;
import com.lark.oapi.service.document_ai.v1.V1;
import com.lark.oapi.service.document_ai.v1.resource.*;

public class DocumentAiService {
    private final V1 v1;
    private final BankCard bankCard; // bank_card
    private final BusinessCard businessCard; // business_card
    private final BusinessLicense businessLicense; // business_license
    private final ChinesePassport chinesePassport; // chinese_passport
    private final Contract contract; // contract
    private final DrivingLicense drivingLicense; // driving_license
    private final FoodManageLicense foodManageLicense; // food_manage_license
    private final FoodProduceLicense foodProduceLicense; // food_produce_license
    private final HealthCertificate healthCertificate; // health_certificate
    private final HkmMainlandTravelPermit hkmMainlandTravelPermit; // hkm_mainland_travel_permit
    private final IdCard idCard; // id_card
    private final Resume resume; // resume
    private final TaxiInvoice taxiInvoice; // taxi_invoice
    private final TrainInvoice trainInvoice; // train_invoice
    private final TwMainlandTravelPermit twMainlandTravelPermit; // tw_mainland_travel_permit
    private final VatInvoice vatInvoice; // vat_invoice
    private final VehicleInvoice vehicleInvoice; // vehicle_invoice
    private final VehicleLicense vehicleLicense; // vehicle_license

    public DocumentAiService(Config config) {
        this.v1 = new V1(config);
        this.bankCard = new BankCard(config);
        this.businessCard = new BusinessCard(config);
        this.businessLicense = new BusinessLicense(config);
        this.chinesePassport = new ChinesePassport(config);
        this.contract = new Contract(config);
        this.drivingLicense = new DrivingLicense(config);
        this.foodManageLicense = new FoodManageLicense(config);
        this.foodProduceLicense = new FoodProduceLicense(config);
        this.healthCertificate = new HealthCertificate(config);
        this.hkmMainlandTravelPermit = new HkmMainlandTravelPermit(config);
        this.idCard = new IdCard(config);
        this.resume = new Resume(config);
        this.taxiInvoice = new TaxiInvoice(config);
        this.trainInvoice = new TrainInvoice(config);
        this.twMainlandTravelPermit = new TwMainlandTravelPermit(config);
        this.vatInvoice = new VatInvoice(config);
        this.vehicleInvoice = new VehicleInvoice(config);
        this.vehicleLicense = new VehicleLicense(config);
    }

    public V1 v1() {
        return v1;
    }

    public BankCard bankCard() {
        return bankCard;
    }

    public BusinessCard businessCard() {
        return businessCard;
    }

    public BusinessLicense businessLicense() {
        return businessLicense;
    }

    public ChinesePassport chinesePassport() {
        return chinesePassport;
    }

    public Contract contract() {
        return contract;
    }

    public DrivingLicense drivingLicense() {
        return drivingLicense;
    }

    public FoodManageLicense foodManageLicense() {
        return foodManageLicense;
    }

    public FoodProduceLicense foodProduceLicense() {
        return foodProduceLicense;
    }

    public HealthCertificate healthCertificate() {
        return healthCertificate;
    }

    public HkmMainlandTravelPermit hkmMainlandTravelPermit() {
        return hkmMainlandTravelPermit;
    }

    public IdCard idCard() {
        return idCard;
    }

    public Resume resume() {
        return resume;
    }

    public TaxiInvoice taxiInvoice() {
        return taxiInvoice;
    }

    public TrainInvoice trainInvoice() {
        return trainInvoice;
    }

    public TwMainlandTravelPermit twMainlandTravelPermit() {
        return twMainlandTravelPermit;
    }

    public VatInvoice vatInvoice() {
        return vatInvoice;
    }

    public VehicleInvoice vehicleInvoice() {
        return vehicleInvoice;
    }

    public VehicleLicense vehicleLicense() {
        return vehicleLicense;
    }
}