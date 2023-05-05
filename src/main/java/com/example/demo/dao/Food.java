package com.example.demo.dao;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "foods")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Food implements Serializable {
	
	private static final long serialVersionUID = 8526900343839466370L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String foodName;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private boolean availability;
	
	@ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    //@JsonIgnoreProperties("foods")
    private Category category;
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime registeredDate;

	@UpdateTimestamp
	private LocalDateTime updatedDate;

}
