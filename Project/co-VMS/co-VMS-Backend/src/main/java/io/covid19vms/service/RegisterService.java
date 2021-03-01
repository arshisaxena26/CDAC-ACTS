package io.covid19vms.service;

import io.covid19vms.authDto.RegisterDto;
import io.covid19vms.authDto.UserDto;
import io.covid19vms.entity.User;

public interface RegisterService {
    UserDto registerUser(RegisterDto dto);
    boolean emailExists(String email);
}
