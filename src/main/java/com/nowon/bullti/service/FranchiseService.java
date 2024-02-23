<<<<<<< HEAD
package com.nowon.bullti.service;

import java.util.List;

import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.storelist.StoreListDTO;

public interface FranchiseService {

    void storeList(Model model);

    List<StoreListDTO> getstoreList();

    List<StoreListDTO> searchStore(String keyword);
=======
package com.nowon.bullti.service;

import java.util.List;

import org.springframework.ui.Model;

import com.nowon.bullti.domain.dto.storelist.StoreListDTO;

public interface FranchiseService {

    void storeList(Model model);

    List<StoreListDTO> getstoreList();

    List<StoreListDTO> searchStore(String keyword);
>>>>>>> refs/remotes/choose_remote_name/master
}