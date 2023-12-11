package com.extension.checker.repository;

import com.extension.checker.domain.Extension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension,Long> {
    @Query("select e from Extension e where e.isCustom = true")
    List<Extension> getCustomExtensions();
    @Query("select e from Extension e where e.isCustom = false")
    List<Extension> getNotCustomExtensions();
    @Query("select e from Extension e where e.name =: name")
    Extension getExtensionByNameIs(String name);

}
