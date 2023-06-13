package com.dali186.developermaker.dto;

import com.dali186.developermaker.entity.Developer;
import com.dali186.developermaker.type.DeveloperLevel;
import com.dali186.developermaker.type.DeveloperSkillType;
import com.dali186.developermaker.type.StatusCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDTO {

    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;

    private Integer experienceYears;
    private String memberId;
    private StatusCode statusCode;
    private String name;
    private Integer age;

    public static DeveloperDetailDTO fromEntity(Developer developer) {
        return DeveloperDetailDTO.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType(developer.getDeveloperSkillType())
                .experienceYears(developer.getExperienceYears())
                .memberId(developer.getMemberId())
                .statusCode(developer.getStatusCode())
                .name(developer.getName())
                .age(developer.getAge())
                .build();
    }

}
