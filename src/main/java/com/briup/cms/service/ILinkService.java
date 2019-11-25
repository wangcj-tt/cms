package com.briup.cms.service;

import com.briup.cms.bean.Link;
import com.briup.cms.exception.CustomerException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ILinkService  {
void saveOrUpdate(Link link) throws CustomerException;

void deleteLink(int id) throws CustomerException;

Link queryById(int id) throws  CustomerException;

List<Link> getAllLink() throws  CustomerException;
}
