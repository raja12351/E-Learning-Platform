package com.example.GrowSkill.Transformers;

import com.example.GrowSkill.DTOs.RequestDto.CertificateDto;
import com.example.GrowSkill.Models.Certificate;

public class CertificateTransformer {
    public static Certificate convertDtoToEntity(CertificateDto certificateDto){
        Certificate certificate = Certificate.builder().certificateUrl(certificateDto.getCertificateUrl()).build();

        return certificate;
    }
}
