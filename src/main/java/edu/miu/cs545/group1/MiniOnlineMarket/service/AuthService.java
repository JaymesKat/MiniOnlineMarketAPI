package edu.miu.cs545.group1.MiniOnlineMarket.service;

import edu.miu.cs545.group1.MiniOnlineMarket.config.UserRole;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Buyer;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.Seller;
import edu.miu.cs545.group1.MiniOnlineMarket.domain.User;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.RegistrationRequestDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.dto.RegistrationResponseDTO;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.BuyerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.SellerRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

public interface AuthService {
    public RegistrationResponseDTO createUser(RegistrationRequestDTO registrationDetails);
}
