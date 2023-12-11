package com.extension.checker.repository;

import com.extension.checker.domain.Extension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtensionRepository extends JpaRepository<Extension,Long> {
}
