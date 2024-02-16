package com.example.springdatajpahibernate.repositories;

import com.example.springdatajpahibernate.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer>{
}
