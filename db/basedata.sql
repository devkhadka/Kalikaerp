

    INSERT INTO `activity` (`id`, `name`, `project_id`) VALUES
    (1, 'Tree Branches Cutting', 1),
    (2, 'wood collection', 1),
    (3, 'Water Drying from dig', 2),
    (4, 'Frame of Bridge construction', 3),
    (5, 'Wall Polishing', 4);
     
     
     
     
     
     
     
     
     
     
     
     
    INSERT INTO `company` (`id`, `address`, `alias`, `email_id`, `file`, `name`, `picture`, `po_box_number`, `postal_address`, `registration_number`, `tax_office`, `telephone_no`, `vat_pan`, `website`, `country_id`, `currency_id`, `industries_id`) VALUES
    (1, 'India', 'BC', 'info@kalika.com', '', 'Birla Cement ', '', '77777', 'Delhi', '88888', 'India', '987654321', 99999, 'www.kalika.com', 2, 2, 2),
    (2, 'Kathmandu', 'KC', 'info@kalika.com', '', 'Kalika Cement', '', '33333', 'kathmandu', '22222', 'kathmandu', '0123456789', 11111, 'www.kalika.com', 3, 2, 2),
    (3, 'Kathmandu', 'SH', 'info@kalika.com', '', 'Sweet Homes', '', '4056', 'Biratnagar,main chowk', '22222', 'Biratnagar', '9876543201', 11111, 'www.kalika.com', 3, 2, 1),
    (4, 'Hetauda', 'KHP', 'info@kalika.com', '', 'Kalika Hydro Power', '', '9087', 'Hetauda,Birendra Chowk', '66666', 'Hetauda', '9087657567', 55555, 'www.kalika.com', 3, 2, 1),
    (5, 'Bhaktapur', 'MM', 'info@kalika.com', '', 'Morning Milks', '', '9087', 'kathmandu', '88888', 'Bhaktapur', '908767556', 77777, 'www.kalika.com', 3, 2, 2);
     
     
    INSERT INTO `country` (`id`, `country_code`, `name`) VALUES
    (1, 'USA', 'washington'),
    (2, 'India', 'Delhi'),
    (3, 'Nepal', 'Kathmandu');
     
     
    INSERT INTO `currency` (`id`, `abb`, `name`, `country_id`) VALUES
    (1, '$', 'US Ddlar', 1),
    (2, 'Rs', 'Rupee', 2),
    (3, 'Rs.', 'Rupee', 3);
     
     
     
     
    INSERT INTO `equipment_category` (`id`, `description`, `name`, `parent_id`) VALUES
    (1, '', 'Dozer', 0),
    (2, '', 'Switches and Wire', 0);
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
     
     
     
     
    INSERT INTO `industries` (`id`, `line_of_business`, `name`, `remarks`) VALUES
    (1, 'Provides Different Construction Type of Work.Construction company mustily situated in Nepal and India ', 'Construction', ''),
    (2, 'Provides Different Manufacturing Type of Work.Company mostly lies in Nepal.', 'Manufacturing', '');
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    INSERT INTO `material` (`id`, `material_derscription`, `material_group_id`, `material_master_id`, `unit_group_id`) VALUES
    (65539, 'Plaster of Paris', 2, 2, 65537),
    (65538, 'Sand', 2, 2, 65537),
    (65537, 'Switches and Wire', 1, 1, 65540),
    (65536, 'Cement', 2, 1, 65537);
	
	
     
     
    INSERT INTO `material_group` (`id`, `name`, `parent_id`) VALUES
    (1, 'Electronics and Electrical', NULL),
    (2, 'Raw Material', NULL);
     
     
     
     
    INSERT INTO `material_master` (`id`, `industries_id`) VALUES
    (1, 1),
    (2, 2);
     
     
     
     
     
     
	 
     
     
    INSERT INTO `project` (`id`, `address`, `alias`, `email_id`, `file`, `file1`, `name`, `picture`, `po_box_number`, `postal_address`, `registration_name`, `tax_office`, `telephone_no`, `vat_pan`, `website`, `company_id`, `country_id`, `currency_id`) VALUES
    (1, 'Bhaktapur,Near Old Hill', '', '', '', '', 'Tree Harvesting', '', '', '', '', 'Kathmandu', NULL, NULL, '', 5, 3, 2),
    (2, 'kathmandu,Near sanepa Height', '', '', '', '', 'Earth digging', '', '', '', '', '', NULL, NULL, '', 3, 3, 2),
    (3, '', '', '', '', '', '45 meter pool Construction', '', '', '', '', '', NULL, NULL, '', 4, 3, 2),
    (4, '', '', '', '', '', 'Wall Painting', '', '', '', '', '', NULL, NULL, '', 1, 3, 2),
    (5, '', '', '', '', '', 'Road Digging', '', '', '', '', '', NULL, NULL, '', 2, 3, 2);
     
     
     
     
    INSERT INTO `purchase_order` (`id`, `amount`, `company`, `currency`, `external_doc_number`, `number`, `project`, `supplier_vat_pan`, `terms_conditions`, `supplier_id`) VALUES
    (1, 3000, 'Kalika Cement', 'Rs', '', '12345', 'Kalika Project', 2345, 'All goods Should be buy', 1);
     
     
     
     
    INSERT INTO `purchase_request` (`id`, `description`) VALUES
    (98305, 'Material for company B&B'),
    (98304, 'Material should be purchase'),
	(851, 'Purchase  this good');
     
     
    INSERT INTO `purchase_request_material` (`id`, `material_id`, `complete`,  `expected_date`, `expexted_quantity`, `location_delivery`, `raised_by`, `project_id`, `unit_id`, `purchase_request_id`) VALUES
    (98305, 65539, 0, '2012-01-01',  100, 'Kathmandu', 'hari', 2, 65537, 98304);
	
     
     
     
     
     
     
     
     
    INSERT INTO `status_material` (`id`, `description`, `type_number`) VALUES
    (1, 'All goods are fine', 1234);
     
         
     
     
     
    INSERT INTO `stores` (`id`, `location`, `name`, `company_id`) VALUES
    (1, '', 'Birla Cement Stores', 1),
    (2, '', 'Kalika Cement Stores', 2),
    (3, '', 'Sweet Homes Stores', 3),
    (4, '', 'Kalika Hydro Power Stores', 4),
    (5, '', 'Morning Milk Stores', 5);
     
     
     
     
     
     
     
     
    INSERT INTO `store_location` (`id`, `name`, `parent_id`, `stores_id`) VALUES
    (1, 'StoreA', NULL, 1),
    (2, 'StoreB', NULL, 1),
    (3, 'BlockA', 1, 1),
    (4, 'BlockB', 1, 1),
    (5, 'BlockC', 2, 1);
     
     
     
     
     
     
     
     
     
     
    INSERT INTO `subcontractor` (`id`, `project_id`) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);
     
     
     
     
     
     
    INSERT INTO `supplier` (`id`, `group_id`, `industries_id`) VALUES
    (1, 1, 1);
     
     
    INSERT INTO `supplier_group` (`id`, `name`) VALUES
    (1, 'Transport supplier'),
    (2, 'Heavy Equipment Supplier'),
    (3, 'Cement Raw Material Supplier'),
    (4, 'Shakti Oil Supplier'),
    (5, 'Electrical Utensil Supplier');
     
     
    INSERT INTO `unit` (`id`, `conversion_factor`, `is_default`, `name`, `unit_group_id`) VALUES
    (65539, 1, 0, 'piec', 65540),
    (65538, 1, 0, 'square meter', 65539),
    (65537, 1, 0, 'Ton', 65540),
    (65536, 1, 0, 'quintal', 65540),
    (65540, 1, 0, 'litre', 65537),
    (65541, 1, 0, 'meter', 65538);
     
     
    INSERT INTO `unit_group` (`id`, `name`, `default_unit_id`) VALUES
    (65539, 'Area', NULL),
    (65538, 'Length', NULL),
    (65537, 'volume', NULL),
    (65540, 'Number', NULL);

