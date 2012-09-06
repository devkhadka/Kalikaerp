-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 03, 2012 at 02:31 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `KalikaLatest`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
CREATE TABLE IF NOT EXISTS `activity` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9D4BF30F7380434C` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `activity`:
--   `project_id`
--       `project` -> `id`
--

--
-- Dumping data for table `activity`
--


-- --------------------------------------------------------

--
-- Table structure for table `approve_materials_requisiton`
--

DROP TABLE IF EXISTS `approve_materials_requisiton`;
CREATE TABLE IF NOT EXISTS `approve_materials_requisiton` (
  `id` int(11) NOT NULL,
  `approve_quantity` double DEFAULT NULL,
  `issue_completed` int(11) DEFAULT NULL,
  `reasons_of_rejection` longtext,
  `reject_quantity` double DEFAULT NULL,
  `requisition_delivery_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE9DB8E7059C93C48` (`unit_id`),
  KEY `FKE9DB8E7024E81405` (`requisition_delivery_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `approve_materials_requisiton`:
--   `requisition_delivery_id`
--       `requisition_delivery` -> `id`
--   `unit_id`
--       `unit` -> `id`
--

--
-- Dumping data for table `approve_materials_requisiton`
--


-- --------------------------------------------------------

--
-- Table structure for table `approve_purchase_request_material`
--

DROP TABLE IF EXISTS `approve_purchase_request_material`;
CREATE TABLE IF NOT EXISTS `approve_purchase_request_material` (
  `id` int(11) NOT NULL,
  `approved_by` varchar(45) DEFAULT NULL,
  `complete` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `location_delivery` varchar(45) DEFAULT NULL,
  `project` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `purchase_request_material_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK111219E3A5ACFF0C` (`purchase_request_material_id`),
  KEY `FK111219E359C93C48` (`unit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `approve_purchase_request_material`:
--   `unit_id`
--       `unit` -> `id`
--   `purchase_request_material_id`
--       `purchase_request_material` -> `id`
--

--
-- Dumping data for table `approve_purchase_request_material`
--


-- --------------------------------------------------------

--
-- Table structure for table `approve_site_transfer`
--

DROP TABLE IF EXISTS `approve_site_transfer`;
CREATE TABLE IF NOT EXISTS `approve_site_transfer` (
  `id` int(11) NOT NULL,
  `approved_quantity` double DEFAULT NULL,
  `rejected_quantity` double DEFAULT NULL,
  `remarks` longtext,
  `site_transfer_details_id` int(11) NOT NULL,
  `unit_id_approved` int(11) NOT NULL,
  `unit_id_rejected` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4F17D4717B9A6DB2` (`unit_id_approved`),
  KEY `FK4F17D4717B18ED6` (`site_transfer_details_id`),
  KEY `FK4F17D47110B01B79` (`unit_id_rejected`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `approve_site_transfer`:
--   `unit_id_rejected`
--       `unit` -> `id`
--   `site_transfer_details_id`
--       `site_transfer_details` -> `id`
--   `unit_id_approved`
--       `unit` -> `id`
--

--
-- Dumping data for table `approve_site_transfer`
--


-- --------------------------------------------------------

--
-- Table structure for table `close_exceptions_remarks`
--

DROP TABLE IF EXISTS `close_exceptions_remarks`;
CREATE TABLE IF NOT EXISTS `close_exceptions_remarks` (
  `id` int(11) NOT NULL,
  `po_number` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `sto_number` varchar(45) DEFAULT NULL,
  `store_receive_fine_details_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ACC3F5FBA3A6C5B` (`store_receive_fine_details_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `close_exceptions_remarks`:
--   `store_receive_fine_details_id`
--       `store_receive_fine_details` -> `id`
--

--
-- Dumping data for table `close_exceptions_remarks`
--


-- --------------------------------------------------------

--
-- Table structure for table `close_slips`
--

DROP TABLE IF EXISTS `close_slips`;
CREATE TABLE IF NOT EXISTS `close_slips` (
  `id` int(11) NOT NULL,
  `slip_number` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EB9262CB6DC5545` (`slip_number`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `close_slips`:
--   `slip_number`
--       `issue_fuel_n_fluid_slip` -> `slip_number`
--

--
-- Dumping data for table `close_slips`
--


-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `alias` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `po_box_number` varchar(45) DEFAULT NULL,
  `postal_address` varchar(45) DEFAULT NULL,
  `registration_number` varchar(45) DEFAULT NULL,
  `tax_office` varchar(45) DEFAULT NULL,
  `telephone_no` varchar(45) DEFAULT NULL,
  `vat_pan` int(11) NOT NULL,
  `website` longtext,
  `country_id` int(11) NOT NULL,
  `currency_id` int(11) NOT NULL,
  `industries_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38A73C7D1CDA6C8` (`industries_id`),
  KEY `FK38A73C7DB5525E28` (`currency_id`),
  KEY `FK38A73C7DF7CD962C` (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `company`:
--   `country_id`
--       `country` -> `id`
--   `industries_id`
--       `industries` -> `id`
--   `currency_id`
--       `currency` -> `id`
--

--
-- Dumping data for table `company`
--


-- --------------------------------------------------------

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL,
  `country_code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--


-- --------------------------------------------------------

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
CREATE TABLE IF NOT EXISTS `currency` (
  `id` int(11) NOT NULL,
  `abb` varchar(10) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK224BF011F7CD962C` (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `currency`:
--   `country_id`
--       `country` -> `id`
--

--
-- Dumping data for table `currency`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
CREATE TABLE IF NOT EXISTS `equipment` (
  `id` int(11) NOT NULL,
  `alias` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `hired_date` date DEFAULT NULL,
  `hired_owned` int(11) DEFAULT NULL,
  `makeEngine` varchar(255) DEFAULT NULL,
  `modelNo` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `purchaseDate` date DEFAULT NULL,
  `serial_number` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `used_hours` int(11) DEFAULT '0',
  `company_id` int(11) NOT NULL,
  `currency_id` int(11) NOT NULL,
  `equipment_category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4027E58EB5525E28` (`currency_id`),
  KEY `FK4027E58E17C18CC` (`company_id`),
  KEY `FK4027E58E7FEDE129` (`equipment_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment`:
--   `equipment_category_id`
--       `equipment_category` -> `id`
--   `company_id`
--       `company` -> `id`
--   `currency_id`
--       `currency` -> `id`
--

--
-- Dumping data for table `equipment`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_category`
--

DROP TABLE IF EXISTS `equipment_category`;
CREATE TABLE IF NOT EXISTS `equipment_category` (
  `id` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipment_category`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_category_has_equipment_parts`
--

DROP TABLE IF EXISTS `equipment_category_has_equipment_parts`;
CREATE TABLE IF NOT EXISTS `equipment_category_has_equipment_parts` (
  `equipment_category_id` int(11) NOT NULL,
  `equipment_parts_id` int(11) NOT NULL,
  KEY `FK7A4A0D9A7FEDE129` (`equipment_category_id`),
  KEY `FK7A4A0D9ABCCA13EB` (`equipment_parts_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_category_has_equipment_parts`:
--   `equipment_parts_id`
--       `equipment_parts` -> `id`
--   `equipment_category_id`
--       `equipment_category` -> `id`
--

--
-- Dumping data for table `equipment_category_has_equipment_parts`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_finance_detail`
--

DROP TABLE IF EXISTS `equipment_finance_detail`;
CREATE TABLE IF NOT EXISTS `equipment_finance_detail` (
  `id` int(11) NOT NULL,
  `next_due_date` date DEFAULT NULL,
  `other_charges` double DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `equipment_financing_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA696172735A3B40B` (`equipment_financing_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_finance_detail`:
--   `equipment_financing_id`
--       `equipment_financing` -> `id`
--

--
-- Dumping data for table `equipment_finance_detail`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_financing`
--

DROP TABLE IF EXISTS `equipment_financing`;
CREATE TABLE IF NOT EXISTS `equipment_financing` (
  `id` int(11) NOT NULL,
  `contract_number` varchar(45) DEFAULT NULL,
  `down_payment` double DEFAULT NULL,
  `finance_amount` double DEFAULT NULL,
  `financer` varchar(45) DEFAULT NULL,
  `first_installment_due` date DEFAULT NULL,
  `full_amount` double DEFAULT NULL,
  `installment_amount` varchar(45) DEFAULT NULL,
  `installment_number` int(11) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `roi` double DEFAULT NULL,
  `equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK62B9A4A6B4D2EEAC` (`equipment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_financing`:
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `equipment_financing`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_has_equipment_parts`
--

DROP TABLE IF EXISTS `equipment_has_equipment_parts`;
CREATE TABLE IF NOT EXISTS `equipment_has_equipment_parts` (
  `equipment_id` int(11) NOT NULL,
  `equipment_parts_id` int(11) NOT NULL,
  KEY `FKA02A1519B4D2EEAC` (`equipment_id`),
  KEY `FKA02A1519BCCA13EB` (`equipment_parts_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_has_equipment_parts`:
--   `equipment_parts_id`
--       `equipment_parts` -> `id`
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `equipment_has_equipment_parts`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_insurance`
--

DROP TABLE IF EXISTS `equipment_insurance`;
CREATE TABLE IF NOT EXISTS `equipment_insurance` (
  `id` int(11) NOT NULL,
  `cover_end_date` datetime DEFAULT NULL,
  `cover_start_date` datetime DEFAULT NULL,
  `insured_amount` varchar(45) DEFAULT NULL,
  `insurer` varchar(45) DEFAULT NULL,
  `policy` varchar(45) DEFAULT NULL,
  `premium` double DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK51C46D69B4D2EEAC` (`equipment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_insurance`:
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `equipment_insurance`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_maintenance`
--

DROP TABLE IF EXISTS `equipment_maintenance`;
CREATE TABLE IF NOT EXISTS `equipment_maintenance` (
  `id` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAD0151E2B4D2EEAC` (`equipment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_maintenance`:
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `equipment_maintenance`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_parts`
--

DROP TABLE IF EXISTS `equipment_parts`;
CREATE TABLE IF NOT EXISTS `equipment_parts` (
  `id` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `model_number` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `usages` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipment_parts`
--


-- --------------------------------------------------------

--
-- Table structure for table `equipment_repairs_materials`
--

DROP TABLE IF EXISTS `equipment_repairs_materials`;
CREATE TABLE IF NOT EXISTS `equipment_repairs_materials` (
  `id` int(11) NOT NULL,
  `material_name` varchar(45) DEFAULT NULL,
  `quanity` varchar(45) DEFAULT NULL,
  `rate` varchar(45) DEFAULT NULL,
  `maintenance_fine_details_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5726E542C7569654` (`maintenance_fine_details_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `equipment_repairs_materials`:
--   `maintenance_fine_details_id`
--       `maintenance_fine_details` -> `id`
--

--
-- Dumping data for table `equipment_repairs_materials`
--


-- --------------------------------------------------------

--
-- Table structure for table `foreign_purchase`
--

DROP TABLE IF EXISTS `foreign_purchase`;
CREATE TABLE IF NOT EXISTS `foreign_purchase` (
  `id` int(11) NOT NULL,
  `clearing_forwarding_charges` double DEFAULT NULL,
  `dock_charges` double DEFAULT NULL,
  `domestic_frieght` double DEFAULT NULL,
  `exchange_rate` double DEFAULT NULL,
  `freight` double DEFAULT NULL,
  `imn` varchar(45) DEFAULT NULL,
  `insurance` double DEFAULT NULL,
  `lc_charge_bank_commission` double DEFAULT NULL,
  `load_unload_charges` double DEFAULT NULL,
  `other_incidiental_expenses` double DEFAULT NULL,
  `import_basis_id` int(11) NOT NULL,
  `purchase_order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF974640C7C66AEA9` (`purchase_order_id`),
  KEY `FKF974640C22352EE1` (`import_basis_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `foreign_purchase`:
--   `import_basis_id`
--       `import_basis` -> `id`
--   `purchase_order_id`
--       `purchase_order` -> `id`
--

--
-- Dumping data for table `foreign_purchase`
--


-- --------------------------------------------------------

--
-- Table structure for table `foreign_purchase_purchase_order_details`
--

DROP TABLE IF EXISTS `foreign_purchase_purchase_order_details`;
CREATE TABLE IF NOT EXISTS `foreign_purchase_purchase_order_details` (
  `foreign_purchase_id` int(11) NOT NULL,
  `purchase_order_details_id` int(11) NOT NULL,
  `custom_accessed_value` double DEFAULT NULL,
  `custom_duty` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `VAT` double DEFAULT NULL,
  PRIMARY KEY (`foreign_purchase_id`,`purchase_order_details_id`),
  KEY `FK3AD82126CA852D0A` (`purchase_order_details_id`),
  KEY `FK3AD82126A237DA55` (`foreign_purchase_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `foreign_purchase_purchase_order_details`:
--   `foreign_purchase_id`
--       `foreign_purchase` -> `id`
--   `purchase_order_details_id`
--       `purchase_order_details` -> `id`
--

--
-- Dumping data for table `foreign_purchase_purchase_order_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `goods_out`
--

DROP TABLE IF EXISTS `goods_out`;
CREATE TABLE IF NOT EXISTS `goods_out` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `goods_out`
--


-- --------------------------------------------------------

--
-- Table structure for table `goods_out_detail`
--

DROP TABLE IF EXISTS `goods_out_detail`;
CREATE TABLE IF NOT EXISTS `goods_out_detail` (
  `id` int(11) NOT NULL,
  `rate` double DEFAULT NULL,
  `approve_materials_requisiton_id` int(11) DEFAULT NULL,
  `approve_site_transfer_id` int(11) DEFAULT NULL,
  `goods_out_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9AD91EEB6C48A51A` (`approve_site_transfer_id`),
  KEY `FK9AD91EEB7C7AFADB` (`goods_out_id`),
  KEY `FK9AD91EEBDA363F62` (`approve_materials_requisiton_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `goods_out_detail`:
--   `approve_materials_requisiton_id`
--       `approve_materials_requisiton` -> `id`
--   `approve_site_transfer_id`
--       `approve_site_transfer` -> `id`
--   `goods_out_id`
--       `goods_out` -> `id`
--

--
-- Dumping data for table `goods_out_detail`
--


-- --------------------------------------------------------

--
-- Table structure for table `goods_out_location`
--

DROP TABLE IF EXISTS `goods_out_location`;
CREATE TABLE IF NOT EXISTS `goods_out_location` (
  `id` int(11) NOT NULL,
  `quantity` double DEFAULT NULL,
  `goods_out_id` int(11) NOT NULL,
  `status_material_id` int(11) NOT NULL,
  `store_location_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7C1767CF87674ACC` (`goods_out_id`),
  KEY `FK7C1767CF59C93C48` (`unit_id`),
  KEY `FK7C1767CFB287F12D` (`status_material_id`),
  KEY `FK7C1767CFABBE39EF` (`store_location_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `goods_out_location`:
--   `store_location_id`
--       `store_location` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `goods_out_id`
--       `goods_out_detail` -> `id`
--   `status_material_id`
--       `status_material` -> `id`
--

--
-- Dumping data for table `goods_out_location`
--


-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequences`
--


-- --------------------------------------------------------

--
-- Table structure for table `import_basis`
--

DROP TABLE IF EXISTS `import_basis`;
CREATE TABLE IF NOT EXISTS `import_basis` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `import_basis`
--


-- --------------------------------------------------------

--
-- Table structure for table `industries`
--

DROP TABLE IF EXISTS `industries`;
CREATE TABLE IF NOT EXISTS `industries` (
  `id` int(11) NOT NULL,
  `line_of_business` longtext,
  `name` varchar(45) DEFAULT NULL,
  `remarks` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `industries`
--


-- --------------------------------------------------------

--
-- Table structure for table `issue_fuel_n_fluid_slip`
--

DROP TABLE IF EXISTS `issue_fuel_n_fluid_slip`;
CREATE TABLE IF NOT EXISTS `issue_fuel_n_fluid_slip` (
  `id` int(11) NOT NULL,
  `issued_to` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `slip_number` varchar(45) DEFAULT NULL,
  `material_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `slip_number` (`slip_number`),
  KEY `FK4150090959C93C48` (`unit_id`),
  KEY `FK41500909E92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `issue_fuel_n_fluid_slip`:
--   `material_id`
--       `material` -> `id`
--   `unit_id`
--       `unit` -> `id`
--

--
-- Dumping data for table `issue_fuel_n_fluid_slip`
--


-- --------------------------------------------------------

--
-- Table structure for table `local_purchase`
--

DROP TABLE IF EXISTS `local_purchase`;
CREATE TABLE IF NOT EXISTS `local_purchase` (
  `id` int(11) NOT NULL,
  `currency_id` int(11) NOT NULL,
  `purchase_order_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK95057F55B5525E28` (`currency_id`),
  KEY `FK95057F557C66AEA9` (`purchase_order_id`),
  KEY `FK95057F5559C93C48` (`unit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `local_purchase`:
--   `unit_id`
--       `unit` -> `id`
--   `purchase_order_id`
--       `purchase_order` -> `id`
--   `currency_id`
--       `currency` -> `id`
--

--
-- Dumping data for table `local_purchase`
--


-- --------------------------------------------------------

--
-- Table structure for table `local_purchase_purchase_order_details`
--

DROP TABLE IF EXISTS `local_purchase_purchase_order_details`;
CREATE TABLE IF NOT EXISTS `local_purchase_purchase_order_details` (
  `local_purchase_id` int(11) NOT NULL,
  `purchase_order_details_id` int(11) NOT NULL,
  `expense` double DEFAULT NULL,
  `remarks` longtext,
  PRIMARY KEY (`local_purchase_id`,`purchase_order_details_id`),
  KEY `FK32AA63BDCA852D0A` (`purchase_order_details_id`),
  KEY `FK32AA63BD8876CA83` (`local_purchase_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `local_purchase_purchase_order_details`:
--   `local_purchase_id`
--       `local_purchase` -> `id`
--   `purchase_order_details_id`
--       `purchase_order_details` -> `id`
--

--
-- Dumping data for table `local_purchase_purchase_order_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `maintenance_detail`
--

DROP TABLE IF EXISTS `maintenance_detail`;
CREATE TABLE IF NOT EXISTS `maintenance_detail` (
  `id` int(11) NOT NULL,
  `equipment_maintenance_id` int(11) NOT NULL,
  `repair_order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2A7A16FD683C5311` (`repair_order_id`),
  KEY `FK2A7A16FDD5E11A4B` (`equipment_maintenance_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `maintenance_detail`:
--   `equipment_maintenance_id`
--       `equipment_maintenance` -> `id`
--   `repair_order_id`
--       `repair_order` -> `id`
--

--
-- Dumping data for table `maintenance_detail`
--


-- --------------------------------------------------------

--
-- Table structure for table `maintenance_details`
--

DROP TABLE IF EXISTS `maintenance_details`;
CREATE TABLE IF NOT EXISTS `maintenance_details` (
  `id` int(11) NOT NULL,
  `material_id` int(11) DEFAULT NULL,
  `material_name` varchar(45) DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `scheduled_maintenances_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK24C8C916BED9465F` (`scheduled_maintenances_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `maintenance_details`:
--   `scheduled_maintenances_id`
--       `maintenance_schedules` -> `id`
--

--
-- Dumping data for table `maintenance_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `maintenance_fine_details`
--

DROP TABLE IF EXISTS `maintenance_fine_details`;
CREATE TABLE IF NOT EXISTS `maintenance_fine_details` (
  `id` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `labour_rate` double DEFAULT NULL,
  `overhead` double DEFAULT NULL,
  `maintenance_detail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEED582699439F893` (`maintenance_detail_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `maintenance_fine_details`:
--   `maintenance_detail_id`
--       `maintenance_detail` -> `id`
--

--
-- Dumping data for table `maintenance_fine_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `maintenance_schedules`
--

DROP TABLE IF EXISTS `maintenance_schedules`;
CREATE TABLE IF NOT EXISTS `maintenance_schedules` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `scheduled_hours` double DEFAULT NULL,
  `equipment_id` int(11) NOT NULL,
  `scheduled_maintenance_types_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK81C13290B4D2EEAC` (`equipment_id`),
  KEY `FK81C132909F7D7644` (`scheduled_maintenance_types_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `maintenance_schedules`:
--   `scheduled_maintenance_types_id`
--       `scheduled_maintenance_types` -> `id`
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `maintenance_schedules`
--


-- --------------------------------------------------------

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
CREATE TABLE IF NOT EXISTS `material` (
  `id` int(11) NOT NULL,
  `material_derscription` varchar(45) DEFAULT NULL,
  `material_group_id` int(11) NOT NULL,
  `material_master_id` int(11) NOT NULL,
  `unit_group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK11D365275A4C73D` (`material_group_id`),
  KEY `FK11D36527AB3CD243` (`unit_group_id`),
  KEY `FK11D365271D3BA0F7` (`material_master_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `material`:
--   `material_master_id`
--       `material_master` -> `id`
--   `material_group_id`
--       `material_group` -> `id`
--   `unit_group_id`
--       `unit_group` -> `id`
--

--
-- Dumping data for table `material`
--


-- --------------------------------------------------------

--
-- Table structure for table `material_group`
--

DROP TABLE IF EXISTS `material_group`;
CREATE TABLE IF NOT EXISTS `material_group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB4040567E119591A` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `material_group`:
--   `parent_id`
--       `material_group` -> `id`
--

--
-- Dumping data for table `material_group`
--


-- --------------------------------------------------------

--
-- Table structure for table `material_group_has_material`
--

DROP TABLE IF EXISTS `material_group_has_material`;
CREATE TABLE IF NOT EXISTS `material_group_has_material` (
  `material_group_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  KEY `FK950F5045A4C73D` (`material_group_id`),
  KEY `FK950F504E92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `material_group_has_material`:
--   `material_id`
--       `material` -> `id`
--   `material_group_id`
--       `material_group` -> `id`
--

--
-- Dumping data for table `material_group_has_material`
--


-- --------------------------------------------------------

--
-- Table structure for table `material_master`
--

DROP TABLE IF EXISTS `material_master`;
CREATE TABLE IF NOT EXISTS `material_master` (
  `id` int(11) NOT NULL,
  `industries_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD5CBF87A1CDA6C8` (`industries_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `material_master`:
--   `industries_id`
--       `industries` -> `id`
--

--
-- Dumping data for table `material_master`
--


-- --------------------------------------------------------

--
-- Table structure for table `material_requisition`
--

DROP TABLE IF EXISTS `material_requisition`;
CREATE TABLE IF NOT EXISTS `material_requisition` (
  `id` int(11) NOT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `location_delivery` varchar(45) DEFAULT NULL,
  `requisiton_to_be_raised_date` date DEFAULT NULL,
  `material_requistion_type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE75F9184939972B2` (`material_requistion_type_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `material_requisition`:
--   `material_requistion_type_id`
--       `material_requistion_type` -> `id`
--

--
-- Dumping data for table `material_requisition`
--


-- --------------------------------------------------------

--
-- Table structure for table `material_requistion_type`
--

DROP TABLE IF EXISTS `material_requistion_type`;
CREATE TABLE IF NOT EXISTS `material_requistion_type` (
  `id` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `material_requistion_type`
--


-- --------------------------------------------------------

--
-- Table structure for table `process_approved_requisitions`
--

DROP TABLE IF EXISTS `process_approved_requisitions`;
CREATE TABLE IF NOT EXISTS `process_approved_requisitions` (
  `id` int(11) NOT NULL,
  `processed_by` varchar(45) DEFAULT NULL,
  `processed_date` date DEFAULT NULL,
  `quantity_PO` varchar(45) DEFAULT NULL,
  `quantity_PO_unit_id` varchar(255) DEFAULT NULL,
  `quantity_stores` varchar(45) DEFAULT NULL,
  `quantity_stores_unit_id` varchar(255) DEFAULT NULL,
  `stores` varchar(45) DEFAULT NULL,
  `approve_purchase_request_material_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1C6FFA0F1EA41B0F` (`approve_purchase_request_material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `process_approved_requisitions`:
--   `approve_purchase_request_material_id`
--       `approve_materials_requisiton` -> `id`
--

--
-- Dumping data for table `process_approved_requisitions`
--


-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL,
  `address` longtext,
  `alias` varchar(45) DEFAULT NULL,
  `email_id` varchar(45) DEFAULT NULL,
  `file` varchar(45) DEFAULT NULL,
  `file1` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `po_box_number` varchar(45) DEFAULT NULL,
  `postal_address` varchar(45) DEFAULT NULL,
  `registration_name` varchar(45) DEFAULT NULL,
  `tax_office` varchar(45) DEFAULT NULL,
  `telephone_no` int(11) DEFAULT NULL,
  `vat_pan` int(11) DEFAULT NULL,
  `website` longtext,
  `company_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `currency_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED904B19B5525E28` (`currency_id`),
  KEY `FKED904B1917C18CC` (`company_id`),
  KEY `FKED904B19F7CD962C` (`country_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `project`:
--   `country_id`
--       `country` -> `id`
--   `company_id`
--       `company` -> `id`
--   `currency_id`
--       `currency` -> `id`
--

--
-- Dumping data for table `project`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_costs`
--

DROP TABLE IF EXISTS `purchase_costs`;
CREATE TABLE IF NOT EXISTS `purchase_costs` (
  `id` int(11) NOT NULL,
  `exchange_rate` double DEFAULT NULL,
  `currency_id` int(11) NOT NULL,
  `purchase_order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK70FB2D88B5525E28` (`currency_id`),
  KEY `FK70FB2D887C66AEA9` (`purchase_order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `purchase_costs`:
--   `purchase_order_id`
--       `purchase_order` -> `id`
--   `currency_id`
--       `currency` -> `id`
--

--
-- Dumping data for table `purchase_costs`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE IF NOT EXISTS `purchase_order` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `currency` longtext,
  `external_doc_number` longtext,
  `number` varchar(45) DEFAULT NULL,
  `project` varchar(45) DEFAULT NULL,
  `supplier_vat_pan` int(11) DEFAULT NULL,
  `terms_conditions` longtext,
  `supplier_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK71A56A90EFBEC048` (`supplier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `purchase_order`:
--   `supplier_id`
--       `supplier` -> `id`
--

--
-- Dumping data for table `purchase_order`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_order_details`
--

DROP TABLE IF EXISTS `purchase_order_details`;
CREATE TABLE IF NOT EXISTS `purchase_order_details` (
  `id` int(11) NOT NULL,
  `amount` double DEFAULT NULL,
  `location_delivery` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `approve_purchase_request_material_id` int(11) NOT NULL,
  `purchase_order_id` int(11) NOT NULL,
  `stores_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA28273937C66AEA9` (`purchase_order_id`),
  KEY `FKA28273939F54180D` (`approve_purchase_request_material_id`),
  KEY `FKA282739359C93C48` (`unit_id`),
  KEY `FKA28273938A6BDA08` (`stores_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `purchase_order_details`:
--   `stores_id`
--       `stores` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `purchase_order_id`
--       `purchase_order` -> `id`
--   `approve_purchase_request_material_id`
--       `approve_purchase_request_material` -> `id`
--

--
-- Dumping data for table `purchase_order_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_request`
--

DROP TABLE IF EXISTS `purchase_request`;
CREATE TABLE IF NOT EXISTS `purchase_request` (
  `id` int(11) NOT NULL,
  `request_process_date` date DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_request`
--


-- --------------------------------------------------------

--
-- Table structure for table `purchase_request_material`
--

DROP TABLE IF EXISTS `purchase_request_material`;
CREATE TABLE IF NOT EXISTS `purchase_request_material` (
  `id` int(11) NOT NULL,
  `complete` tinyint(1) DEFAULT NULL,
  `expected_date` date DEFAULT NULL,
  `expexted_quantity` double DEFAULT NULL,
  `location_delivery` longtext,
  `raised_by` varchar(45) DEFAULT NULL,
  `material_id` int(11) NOT NULL,
  `project_id` int(11) DEFAULT NULL,
  `purchase_request_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK23DCF4557380434C` (`project_id`),
  KEY `FK23DCF4555BDD2B49` (`purchase_request_id`),
  KEY `FK23DCF45559C93C48` (`unit_id`),
  KEY `FK23DCF455E92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `purchase_request_material`:
--   `material_id`
--       `material` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `purchase_request_id`
--       `purchase_request` -> `id`
--   `project_id`
--       `project` -> `id`
--

--
-- Dumping data for table `purchase_request_material`
--


-- --------------------------------------------------------

--
-- Table structure for table `receving_type`
--

DROP TABLE IF EXISTS `receving_type`;
CREATE TABLE IF NOT EXISTS `receving_type` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receving_type`
--


-- --------------------------------------------------------

--
-- Table structure for table `reject_purchase_request`
--

DROP TABLE IF EXISTS `reject_purchase_request`;
CREATE TABLE IF NOT EXISTS `reject_purchase_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` double DEFAULT NULL,
  `purchase_request_material_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6846CDF1A5ACFF0C` (`purchase_request_material_id`),
  KEY `FK6846CDF159C93C48` (`unit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- RELATIONS FOR TABLE `reject_purchase_request`:
--   `unit_id`
--       `unit` -> `id`
--   `purchase_request_material_id`
--       `purchase_request_material` -> `id`
--

--
-- Dumping data for table `reject_purchase_request`
--


-- --------------------------------------------------------

--
-- Table structure for table `repairs`
--

DROP TABLE IF EXISTS `repairs`;
CREATE TABLE IF NOT EXISTS `repairs` (
  `id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `remarks` longtext,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4137D28617C18CC` (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `repairs`:
--   `company_id`
--       `company` -> `id`
--

--
-- Dumping data for table `repairs`
--


-- --------------------------------------------------------

--
-- Table structure for table `repairs_has_project`
--

DROP TABLE IF EXISTS `repairs_has_project`;
CREATE TABLE IF NOT EXISTS `repairs_has_project` (
  `repairs_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  KEY `FK7728E23BBBB0702C` (`repairs_id`),
  KEY `FK7728E23B7380434C` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `repairs_has_project`:
--   `project_id`
--       `project` -> `id`
--   `repairs_id`
--       `repairs` -> `id`
--

--
-- Dumping data for table `repairs_has_project`
--


-- --------------------------------------------------------

--
-- Table structure for table `repair_order`
--

DROP TABLE IF EXISTS `repair_order`;
CREATE TABLE IF NOT EXISTS `repair_order` (
  `id` int(11) NOT NULL,
  `estimated_cost` varchar(45) DEFAULT NULL,
  `estimated_time` int(11) DEFAULT NULL,
  `materials_required` varchar(255) DEFAULT NULL,
  `mechanic_name` varchar(45) DEFAULT NULL,
  `problem` varchar(255) DEFAULT NULL,
  `time_unit` int(11) DEFAULT NULL,
  `equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBB56C1CB4D2EEAC` (`equipment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `repair_order`:
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `repair_order`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_delivery`
--

DROP TABLE IF EXISTS `requisition_delivery`;
CREATE TABLE IF NOT EXISTS `requisition_delivery` (
  `id` int(11) NOT NULL,
  `delivery_date` date DEFAULT NULL,
  `pending` int(11) DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  `request_process_date` date DEFAULT NULL,
  `requisition_material_activity_Subcontractor_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6B1BEC37DC2C1B51` (`requisition_material_activity_Subcontractor_id`),
  KEY `FK6B1BEC3759C93C48` (`unit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `requisition_delivery`:
--   `unit_id`
--       `unit` -> `id`
--   `requisition_material_activity_Subcontractor_id`
--       `requisition_material_activity_subcontractor` -> `id`
--

--
-- Dumping data for table `requisition_delivery`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_material`
--

DROP TABLE IF EXISTS `requisition_material`;
CREATE TABLE IF NOT EXISTS `requisition_material` (
  `id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `material_requisition_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4BDA356AE29B7FDD` (`material_requisition_id`),
  KEY `FK4BDA356AE92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `requisition_material`:
--   `material_id`
--       `material` -> `id`
--   `material_requisition_id`
--       `material_requisition` -> `id`
--

--
-- Dumping data for table `requisition_material`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_material_activity`
--

DROP TABLE IF EXISTS `requisition_material_activity`;
CREATE TABLE IF NOT EXISTS `requisition_material_activity` (
  `id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `requistion_material_project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK66EB6644448071BE` (`requistion_material_project_id`),
  KEY `FK66EB6644D6AE9568` (`activity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `requisition_material_activity`:
--   `activity_id`
--       `activity` -> `id`
--   `requistion_material_project_id`
--       `requistion_material_project` -> `id`
--

--
-- Dumping data for table `requisition_material_activity`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_material_activity_subcontractor`
--

DROP TABLE IF EXISTS `requisition_material_activity_subcontractor`;
CREATE TABLE IF NOT EXISTS `requisition_material_activity_subcontractor` (
  `id` int(11) NOT NULL,
  `requisition_material_activity_id` int(11) NOT NULL,
  `subcontractor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK596501FAD86EFE3A` (`requisition_material_activity_id`),
  KEY `FK596501FA385DA04C` (`subcontractor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `requisition_material_activity_subcontractor`:
--   `subcontractor_id`
--       `subcontractor` -> `id`
--   `requisition_material_activity_id`
--       `requisition_material_activity` -> `id`
--

--
-- Dumping data for table `requisition_material_activity_subcontractor`
--


-- --------------------------------------------------------

--
-- Table structure for table `requisition_rejection`
--

DROP TABLE IF EXISTS `requisition_rejection`;
CREATE TABLE IF NOT EXISTS `requisition_rejection` (
  `id` int(11) NOT NULL,
  `rejected_quantity` double DEFAULT NULL,
  `requisition_delivery_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA27AC42659C93C48` (`unit_id`),
  KEY `FKA27AC42624E81405` (`requisition_delivery_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `requisition_rejection`:
--   `requisition_delivery_id`
--       `requisition_delivery` -> `id`
--   `unit_id`
--       `unit` -> `id`
--

--
-- Dumping data for table `requisition_rejection`
--


-- --------------------------------------------------------

--
-- Table structure for table `requistion_material_project`
--

DROP TABLE IF EXISTS `requistion_material_project`;
CREATE TABLE IF NOT EXISTS `requistion_material_project` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `requisition_material_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8BBE956BA56EA325` (`requisition_material_id`),
  KEY `FK8BBE956B7380434C` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `requistion_material_project`:
--   `project_id`
--       `project` -> `id`
--   `requisition_material_id`
--       `requisition_material` -> `id`
--

--
-- Dumping data for table `requistion_material_project`
--


-- --------------------------------------------------------

--
-- Table structure for table `road_registration`
--

DROP TABLE IF EXISTS `road_registration`;
CREATE TABLE IF NOT EXISTS `road_registration` (
  `id` int(11) NOT NULL,
  `rc_date` date DEFAULT NULL,
  `rc_number` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `equipment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK32CD6778B4D2EEAC` (`equipment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `road_registration`:
--   `equipment_id`
--       `equipment` -> `id`
--

--
-- Dumping data for table `road_registration`
--


-- --------------------------------------------------------

--
-- Table structure for table `scheduled_maintenance_types`
--

DROP TABLE IF EXISTS `scheduled_maintenance_types`;
CREATE TABLE IF NOT EXISTS `scheduled_maintenance_types` (
  `id` int(11) NOT NULL,
  `category` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `scheduled_maintenance_types`
--


-- --------------------------------------------------------

--
-- Table structure for table `site_transfer_details`
--

DROP TABLE IF EXISTS `site_transfer_details`;
CREATE TABLE IF NOT EXISTS `site_transfer_details` (
  `id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `quantity_req` double DEFAULT NULL,
  `material_id` int(11) NOT NULL,
  `process_approved_requisitions_id` int(11) NOT NULL,
  `site_transfer_orders_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBBCF4FE6D5D3393A` (`process_approved_requisitions_id`),
  KEY `FKBBCF4FE648BBF3BE` (`site_transfer_orders_id`),
  KEY `FKBBCF4FE659C93C48` (`unit_id`),
  KEY `FKBBCF4FE6E92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `site_transfer_details`:
--   `material_id`
--       `material` -> `id`
--   `site_transfer_orders_id`
--       `site_transfer_orders` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `process_approved_requisitions_id`
--       `process_approved_requisitions` -> `id`
--

--
-- Dumping data for table `site_transfer_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `site_transfer_orders`
--

DROP TABLE IF EXISTS `site_transfer_orders`;
CREATE TABLE IF NOT EXISTS `site_transfer_orders` (
  `id` int(11) NOT NULL,
  `stores_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5B94C0C18A6BDA08` (`stores_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `site_transfer_orders`:
--   `stores_id`
--       `stores` -> `id`
--

--
-- Dumping data for table `site_transfer_orders`
--


-- --------------------------------------------------------

--
-- Table structure for table `site_transfer_requisition`
--

DROP TABLE IF EXISTS `site_transfer_requisition`;
CREATE TABLE IF NOT EXISTS `site_transfer_requisition` (
  `id` int(11) NOT NULL,
  `expected_date` date DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  `remarks` longtext,
  `requisitioned_by` varchar(45) DEFAULT NULL,
  `ApproveMaterialRequisitionId` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK33203C4059C93C48` (`unit_id`),
  KEY `FK33203C40E92C3E68` (`material_id`),
  KEY `FK33203C405BA849DB` (`ApproveMaterialRequisitionId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `site_transfer_requisition`:
--   `ApproveMaterialRequisitionId`
--       `approve_materials_requisiton` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `material_id`
--       `material` -> `id`
--

--
-- Dumping data for table `site_transfer_requisition`
--


-- --------------------------------------------------------

--
-- Table structure for table `status_material`
--

DROP TABLE IF EXISTS `status_material`;
CREATE TABLE IF NOT EXISTS `status_material` (
  `id` int(11) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `type_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_material`
--


-- --------------------------------------------------------

--
-- Table structure for table `stock_adjustment`
--

DROP TABLE IF EXISTS `stock_adjustment`;
CREATE TABLE IF NOT EXISTS `stock_adjustment` (
  `id` int(11) NOT NULL,
  `add_less` tinyint(1) DEFAULT NULL,
  `add_less_quantity` double DEFAULT NULL,
  `remarks` longtext,
  `material_id` int(11) NOT NULL,
  `stock_location_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK25BF223659C93C48` (`unit_id`),
  KEY `FK25BF2236301E89D9` (`stock_location_id`),
  KEY `FK25BF2236E92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `stock_adjustment`:
--   `material_id`
--       `material` -> `id`
--   `stock_location_id`
--       `stock_location` -> `id`
--   `unit_id`
--       `unit` -> `id`
--

--
-- Dumping data for table `stock_adjustment`
--


-- --------------------------------------------------------

--
-- Table structure for table `stock_location`
--

DROP TABLE IF EXISTS `stock_location`;
CREATE TABLE IF NOT EXISTS `stock_location` (
  `id` int(11) NOT NULL,
  `quantity` double DEFAULT NULL,
  `material_id` int(11) NOT NULL,
  `status_material_id` int(11) NOT NULL,
  `store_location_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5DF72BE59C93C48` (`unit_id`),
  KEY `FK5DF72BEB287F12D` (`status_material_id`),
  KEY `FK5DF72BEE92C3E68` (`material_id`),
  KEY `FK5DF72BEABBE39EF` (`store_location_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `stock_location`:
--   `store_location_id`
--       `store_location` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `status_material_id`
--       `status_material` -> `id`
--   `material_id`
--       `material` -> `id`
--

--
-- Dumping data for table `stock_location`
--


-- --------------------------------------------------------

--
-- Table structure for table `stores`
--

DROP TABLE IF EXISTS `stores`;
CREATE TABLE IF NOT EXISTS `stores` (
  `id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCAD423B217C18CC` (`company_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `stores`:
--   `company_id`
--       `company` -> `id`
--

--
-- Dumping data for table `stores`
--


-- --------------------------------------------------------

--
-- Table structure for table `stores_has_project`
--

DROP TABLE IF EXISTS `stores_has_project`;
CREATE TABLE IF NOT EXISTS `stores_has_project` (
  `stores_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  KEY `FKEA58D1677380434C` (`project_id`),
  KEY `FKEA58D1678A6BDA08` (`stores_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `stores_has_project`:
--   `stores_id`
--       `stores` -> `id`
--   `project_id`
--       `project` -> `id`
--

--
-- Dumping data for table `stores_has_project`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_in`
--

DROP TABLE IF EXISTS `store_in`;
CREATE TABLE IF NOT EXISTS `store_in` (
  `id` int(11) NOT NULL,
  `maximum_level` double DEFAULT NULL,
  `method_of_valuation` varchar(45) DEFAULT NULL,
  `minimum_level` double DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `re_order_level` double DEFAULT NULL,
  `rejected_quantity` double DEFAULT NULL,
  `grn_number` varchar(255) NOT NULL,
  `material_id` int(11) NOT NULL,
  `status_material_id` int(11) NOT NULL,
  `store_location_id` int(11) DEFAULT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6659C1437B327477` (`grn_number`),
  KEY `FK6659C14359C93C48` (`unit_id`),
  KEY `FK6659C143B287F12D` (`status_material_id`),
  KEY `FK6659C143E92C3E68` (`material_id`),
  KEY `FK6659C143ABBE39EF` (`store_location_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_in`:
--   `store_location_id`
--       `store_location` -> `id`
--   `unit_id`
--       `unit` -> `id`
--   `grn_number`
--       `store_receive_details` -> `grn_number`
--   `status_material_id`
--       `status_material` -> `id`
--   `material_id`
--       `material` -> `id`
--

--
-- Dumping data for table `store_in`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_in_detail`
--

DROP TABLE IF EXISTS `store_in_detail`;
CREATE TABLE IF NOT EXISTS `store_in_detail` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `remarks` longtext,
  `serialno` varchar(45) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `store_in_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB823F2CD59C93C48` (`unit_id`),
  KEY `FKB823F2CD31EE27AF` (`store_in_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_in_detail`:
--   `store_in_id`
--       `store_in` -> `id`
--   `unit_id`
--       `unit` -> `id`
--

--
-- Dumping data for table `store_in_detail`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_location`
--

DROP TABLE IF EXISTS `store_location`;
CREATE TABLE IF NOT EXISTS `store_location` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `stores_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK58D4553144D2338` (`parent_id`),
  KEY `FK58D45538A6BDA08` (`stores_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_location`:
--   `stores_id`
--       `stores` -> `id`
--   `parent_id`
--       `store_location` -> `id`
--

--
-- Dumping data for table `store_location`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_material_type`
--

DROP TABLE IF EXISTS `store_material_type`;
CREATE TABLE IF NOT EXISTS `store_material_type` (
  `id` int(11) NOT NULL,
  `store_in_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE2A1307431EE27AF` (`store_in_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_material_type`:
--   `store_in_id`
--       `store_in` -> `id`
--

--
-- Dumping data for table `store_material_type`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_receive`
--

DROP TABLE IF EXISTS `store_receive`;
CREATE TABLE IF NOT EXISTS `store_receive` (
  `id` int(11) NOT NULL,
  `is_complete` tinyint(1) DEFAULT NULL,
  `po_number` varchar(45) DEFAULT NULL,
  `receving_type_id` int(11) NOT NULL,
  `store_location_id` int(11) NOT NULL,
  `stores_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK454AA185F9E351EB` (`receving_type_id`),
  KEY `FK454AA185ABBE39EF` (`store_location_id`),
  KEY `FK454AA1858A6BDA08` (`stores_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_receive`:
--   `stores_id`
--       `stores` -> `id`
--   `store_location_id`
--       `store_location` -> `id`
--   `receving_type_id`
--       `receving_type` -> `id`
--

--
-- Dumping data for table `store_receive`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_receive_details`
--

DROP TABLE IF EXISTS `store_receive_details`;
CREATE TABLE IF NOT EXISTS `store_receive_details` (
  `id` int(11) NOT NULL,
  `carriage_number` varchar(45) DEFAULT NULL,
  `carrier` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `delivery_note_number` varchar(45) DEFAULT NULL,
  `driver` varchar(45) DEFAULT NULL,
  `grn_number` varchar(45) DEFAULT NULL,
  `received_by` varchar(45) DEFAULT NULL,
  `supplier_name` varchar(45) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `verified_by` varchar(45) DEFAULT NULL,
  `store_receive_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `grn_number` (`grn_number`),
  KEY `FK560FE5889820A3E5` (`store_receive_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_receive_details`:
--   `store_receive_id`
--       `store_receive` -> `id`
--

--
-- Dumping data for table `store_receive_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `store_receive_fine_details`
--

DROP TABLE IF EXISTS `store_receive_fine_details`;
CREATE TABLE IF NOT EXISTS `store_receive_fine_details` (
  `id` int(11) NOT NULL,
  `quantity_challan` double DEFAULT NULL,
  `quantity_damaged` double DEFAULT NULL,
  `quantity_received` double DEFAULT NULL,
  `remarks` longtext,
  `material_id` int(11) NOT NULL,
  `store_receive_details_id` int(11) NOT NULL,
  `unit_id_challan` int(11) NOT NULL,
  `unit_id_damaged` int(11) NOT NULL,
  `unit_id_received` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFC285D374C0F0DC` (`unit_id_received`),
  KEY `FKFC285D37F0015952` (`unit_id_challan`),
  KEY `FKFC285D37488BA184` (`store_receive_details_id`),
  KEY `FKFC285D371999AFDE` (`unit_id_damaged`),
  KEY `FKFC285D37E92C3E68` (`material_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `store_receive_fine_details`:
--   `material_id`
--       `material` -> `id`
--   `unit_id_damaged`
--       `unit` -> `id`
--   `store_receive_details_id`
--       `store_receive_details` -> `id`
--   `unit_id_received`
--       `unit` -> `id`
--   `unit_id_challan`
--       `unit` -> `id`
--

--
-- Dumping data for table `store_receive_fine_details`
--


-- --------------------------------------------------------

--
-- Table structure for table `subcontractor`
--

DROP TABLE IF EXISTS `subcontractor`;
CREATE TABLE IF NOT EXISTS `subcontractor` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCDCE10B57380434C` (`project_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `subcontractor`:
--   `project_id`
--       `project` -> `id`
--

--
-- Dumping data for table `subcontractor`
--


-- --------------------------------------------------------

--
-- Table structure for table `subcontractor_has_sub_activity`
--

DROP TABLE IF EXISTS `subcontractor_has_sub_activity`;
CREATE TABLE IF NOT EXISTS `subcontractor_has_sub_activity` (
  `subcontractor_id` int(11) NOT NULL,
  `sub_activity_id` int(11) NOT NULL,
  KEY `FK210A01FDEE4DED6D` (`sub_activity_id`),
  KEY `FK210A01FD385DA04C` (`subcontractor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `subcontractor_has_sub_activity`:
--   `subcontractor_id`
--       `subcontractor` -> `id`
--   `sub_activity_id`
--       `sub_activity` -> `id`
--

--
-- Dumping data for table `subcontractor_has_sub_activity`
--


-- --------------------------------------------------------

--
-- Table structure for table `sub_activity`
--

DROP TABLE IF EXISTS `sub_activity`;
CREATE TABLE IF NOT EXISTS `sub_activity` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `activity_id` int(11) DEFAULT NULL,
  `sub_activity_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA8216E2ED6AE9568` (`activity_id`),
  KEY `FKA8216E2EEE4DED6D` (`sub_activity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `sub_activity`:
--   `sub_activity_id`
--       `sub_activity` -> `id`
--   `activity_id`
--       `activity` -> `id`
--

--
-- Dumping data for table `sub_activity`
--


-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `industries_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9CDBF9CC1CDA6C8` (`industries_id`),
  KEY `FK9CDBF9CC44A4A9A0` (`group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `supplier`:
--   `group_id`
--       `supplier_group` -> `id`
--   `industries_id`
--       `industries` -> `id`
--

--
-- Dumping data for table `supplier`
--


-- --------------------------------------------------------

--
-- Table structure for table `supplier_group`
--

DROP TABLE IF EXISTS `supplier_group`;
CREATE TABLE IF NOT EXISTS `supplier_group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier_group`
--


-- --------------------------------------------------------

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
CREATE TABLE IF NOT EXISTS `unit` (
  `id` int(11) NOT NULL,
  `conversion_factor` double DEFAULT NULL,
  `is_default` tinyint(1) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `unit_group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK36D984AB3CD243` (`unit_group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `unit`:
--   `unit_group_id`
--       `unit_group` -> `id`
--

--
-- Dumping data for table `unit`
--


-- --------------------------------------------------------

--
-- Table structure for table `unit_group`
--

DROP TABLE IF EXISTS `unit_group`;
CREATE TABLE IF NOT EXISTS `unit_group` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `default_unit_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96A400045996E84A` (`default_unit_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


