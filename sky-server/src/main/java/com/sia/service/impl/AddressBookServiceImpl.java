package com.sia.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sia.entity.AddressBook;
import com.sia.service.AddressBookService;
import com.sia.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 32156
* @description 针对表【address_book(地址簿)】的数据库操作Service实现
* @createDate 2025-06-16 19:54:42
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService {

}




