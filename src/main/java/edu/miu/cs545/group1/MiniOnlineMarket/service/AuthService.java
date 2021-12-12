package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.RegistrationRequestDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.RegistrationResponseDTO;

public interface AuthService {
    public RegistrationResponseDTO createUser(RegistrationRequestDTO registrationDetails);
}
