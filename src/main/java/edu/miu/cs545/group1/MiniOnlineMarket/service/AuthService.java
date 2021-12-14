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

    @Service
    @Transactional
    class AuthServiceImpl implements AuthService {

        private UserRepo userRepo;
        private SellerRepo sellerRepo;
        private BuyerRepo buyerRepo;
        private PasswordEncoder passwordEncoder;

        private ModelMapper modelMapper;

        @Autowired
        public AuthServiceImpl(UserRepo userRepo, SellerRepo sellerRepo, BuyerRepo buyerRepo, PasswordEncoder passwordEncoder) {
            this.userRepo = userRepo;
            this.sellerRepo = sellerRepo;
            this.buyerRepo = buyerRepo;
            this.passwordEncoder = passwordEncoder;
        }

        @Autowired
        public void setModelMapper(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        @Override
        public RegistrationResponseDTO createUser(RegistrationRequestDTO registrationRequestDTO) {
            String role = registrationRequestDTO.getRole().toUpperCase().trim();

            if(!UserRole.isValid(role)) {
                throw new RuntimeException("Invalid role");
            }

            User user = new User();
            user.setUsername(registrationRequestDTO.getUsername());
            user.setEmail(registrationRequestDTO.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequestDTO.getPassword()));
            user.setRole(UserRole.valueOf(role));
            user.setEnabled(true);
            userRepo.save(user);

            if(user.getRole().equals(UserRole.SELLER)) {
                Seller seller = new Seller();
                seller.setFirstName(registrationRequestDTO.getFirstName());
                seller.setLastName(registrationRequestDTO.getLastName());
                seller.setEmail(registrationRequestDTO.getEmail());
                seller.setPhone(registrationRequestDTO.getPhone());
                seller.setApproved(false);
                seller.setUser(user);
                sellerRepo.save(seller);

                RegistrationResponseDTO result = modelMapper.map(seller, RegistrationResponseDTO.class);
                result.setUsername(user.getUsername());
                return result;
            }

            Buyer buyer = new Buyer();
            buyer.setFirstName(registrationRequestDTO.getFirstName());
            buyer.setFirstName(registrationRequestDTO.getFirstName());
            buyer.setLastName(registrationRequestDTO.getLastName());
            buyer.setEmail(registrationRequestDTO.getEmail());
            buyer.setPhone(registrationRequestDTO.getPhone());
            buyer.setBillingAddress(registrationRequestDTO.getBillingAddress());
            buyer.setShippingAddress(registrationRequestDTO.getShippingAddress());
            buyer.setUser(user);
            buyerRepo.save(buyer);
            RegistrationResponseDTO result = modelMapper.map(buyer, RegistrationResponseDTO.class);
            result.setUsername(user.getUsername());
            return result;
        }
    }
}
