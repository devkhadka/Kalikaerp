ALTER TABLE `activity`
  ADD CONSTRAINT `FK9D4BF30F7380434C` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Constraints for table `approve_materials_requisiton`
--
ALTER TABLE `approve_materials_requisiton`
  ADD CONSTRAINT `FKE9DB8E7024E81405` FOREIGN KEY (`requisition_delivery_id`) REFERENCES `requisition_delivery` (`id`),
  ADD CONSTRAINT `FKE9DB8E7059C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Constraints for table `approve_purchase_request_material`
--
ALTER TABLE `approve_purchase_request_material`
  ADD CONSTRAINT `FK111219E359C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK111219E3A5ACFF0C` FOREIGN KEY (`purchase_request_material_id`) REFERENCES `purchase_request_material` (`id`);

--
-- Constraints for table `approve_site_transfer`
--
ALTER TABLE `approve_site_transfer`
  ADD CONSTRAINT `FK4F17D47110B01B79` FOREIGN KEY (`unit_id_rejected`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK4F17D4717B18ED6` FOREIGN KEY (`site_transfer_details_id`) REFERENCES `site_transfer_details` (`id`),
  ADD CONSTRAINT `FK4F17D4717B9A6DB2` FOREIGN KEY (`unit_id_approved`) REFERENCES `unit` (`id`);

--
-- Constraints for table `close_exceptions_remarks`
--
ALTER TABLE `close_exceptions_remarks`
  ADD CONSTRAINT `FK7ACC3F5FBA3A6C5B` FOREIGN KEY (`store_receive_fine_details_id`) REFERENCES `store_receive_fine_details` (`id`);

--
-- Constraints for table `close_slips`
--
ALTER TABLE `close_slips`
  ADD CONSTRAINT `FK1EB9262CB6DC5545` FOREIGN KEY (`slip_number`) REFERENCES `issue_fuel_n_fluid_slip` (`slip_number`);

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FK38A73C7DF7CD962C` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  ADD CONSTRAINT `FK38A73C7D1CDA6C8` FOREIGN KEY (`industries_id`) REFERENCES `industries` (`id`),
  ADD CONSTRAINT `FK38A73C7DB5525E28` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`);

--
-- Constraints for table `currency`
--
ALTER TABLE `currency`
  ADD CONSTRAINT `FK224BF011F7CD962C` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`);

--
-- Constraints for table `equipment`
--
ALTER TABLE `equipment`
  ADD CONSTRAINT `FK4027E58E7FEDE129` FOREIGN KEY (`equipment_category_id`) REFERENCES `equipment_category` (`id`),
  ADD CONSTRAINT `FK4027E58E17C18CC` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FK4027E58EB5525E28` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`);

--
-- Constraints for table `equipment_category_has_equipment_parts`
--
ALTER TABLE `equipment_category_has_equipment_parts`
  ADD CONSTRAINT `FK7A4A0D9ABCCA13EB` FOREIGN KEY (`equipment_parts_id`) REFERENCES `equipment_parts` (`id`),
  ADD CONSTRAINT `FK7A4A0D9A7FEDE129` FOREIGN KEY (`equipment_category_id`) REFERENCES `equipment_category` (`id`);

--
-- Constraints for table `equipment_finance_detail`
--
ALTER TABLE `equipment_finance_detail`
  ADD CONSTRAINT `FKA696172735A3B40B` FOREIGN KEY (`equipment_financing_id`) REFERENCES `equipment_financing` (`id`);

--
-- Constraints for table `equipment_financing`
--
ALTER TABLE `equipment_financing`
  ADD CONSTRAINT `FK62B9A4A6B4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `equipment_has_equipment_parts`
--
ALTER TABLE `equipment_has_equipment_parts`
  ADD CONSTRAINT `FKA02A1519BCCA13EB` FOREIGN KEY (`equipment_parts_id`) REFERENCES `equipment_parts` (`id`),
  ADD CONSTRAINT `FKA02A1519B4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `equipment_insurance`
--
ALTER TABLE `equipment_insurance`
  ADD CONSTRAINT `FK51C46D69B4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `equipment_maintenance`
--
ALTER TABLE `equipment_maintenance`
  ADD CONSTRAINT `FKAD0151E2B4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `equipment_repairs_materials`
--
ALTER TABLE `equipment_repairs_materials`
  ADD CONSTRAINT `FK5726E542C7569654` FOREIGN KEY (`maintenance_fine_details_id`) REFERENCES `maintenance_fine_details` (`id`);

--
-- Constraints for table `foreign_purchase`
--
ALTER TABLE `foreign_purchase`
  ADD CONSTRAINT `FKF974640C22352EE1` FOREIGN KEY (`import_basis_id`) REFERENCES `import_basis` (`id`),
  ADD CONSTRAINT `FKF974640C7C66AEA9` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`id`);

--
-- Constraints for table `foreign_purchase_purchase_order_details`
--
ALTER TABLE `foreign_purchase_purchase_order_details`
  ADD CONSTRAINT `FK3AD82126A237DA55` FOREIGN KEY (`foreign_purchase_id`) REFERENCES `foreign_purchase` (`id`),
  ADD CONSTRAINT `FK3AD82126CA852D0A` FOREIGN KEY (`purchase_order_details_id`) REFERENCES `purchase_order_details` (`id`);

--
-- Constraints for table `goods_out_detail`
--
ALTER TABLE `goods_out_detail`
  ADD CONSTRAINT `FK9AD91EEBDA363F62` FOREIGN KEY (`approve_materials_requisiton_id`) REFERENCES `approve_materials_requisiton` (`id`),
  ADD CONSTRAINT `FK9AD91EEB6C48A51A` FOREIGN KEY (`approve_site_transfer_id`) REFERENCES `approve_site_transfer` (`id`),
  ADD CONSTRAINT `FK9AD91EEB7C7AFADB` FOREIGN KEY (`goods_out_id`) REFERENCES `goods_out` (`id`);

--
-- Constraints for table `goods_out_location`
--
ALTER TABLE `goods_out_location`
  ADD CONSTRAINT `FK7C1767CFABBE39EF` FOREIGN KEY (`store_location_id`) REFERENCES `store_location` (`id`),
  ADD CONSTRAINT `FK7C1767CF59C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK7C1767CF87674ACC` FOREIGN KEY (`goods_out_id`) REFERENCES `goods_out_detail` (`id`),
  ADD CONSTRAINT `FK7C1767CFB287F12D` FOREIGN KEY (`status_material_id`) REFERENCES `status_material` (`id`);

--
-- Constraints for table `issue_fuel_n_fluid_slip`
--
ALTER TABLE `issue_fuel_n_fluid_slip`
  ADD CONSTRAINT `FK41500909E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FK4150090959C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Constraints for table `local_purchase`
--
ALTER TABLE `local_purchase`
  ADD CONSTRAINT `FK95057F5559C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK95057F557C66AEA9` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`id`),
  ADD CONSTRAINT `FK95057F55B5525E28` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`);

--
-- Constraints for table `local_purchase_purchase_order_details`
--
ALTER TABLE `local_purchase_purchase_order_details`
  ADD CONSTRAINT `FK32AA63BD8876CA83` FOREIGN KEY (`local_purchase_id`) REFERENCES `local_purchase` (`id`),
  ADD CONSTRAINT `FK32AA63BDCA852D0A` FOREIGN KEY (`purchase_order_details_id`) REFERENCES `purchase_order_details` (`id`);

--
-- Constraints for table `maintenance_detail`
--
ALTER TABLE `maintenance_detail`
  ADD CONSTRAINT `FK2A7A16FDD5E11A4B` FOREIGN KEY (`equipment_maintenance_id`) REFERENCES `equipment_maintenance` (`id`),
  ADD CONSTRAINT `FK2A7A16FD683C5311` FOREIGN KEY (`repair_order_id`) REFERENCES `repair_order` (`id`);

--
-- Constraints for table `maintenance_details`
--
ALTER TABLE `maintenance_details`
  ADD CONSTRAINT `FK24C8C916BED9465F` FOREIGN KEY (`scheduled_maintenances_id`) REFERENCES `maintenance_schedules` (`id`);

--
-- Constraints for table `maintenance_fine_details`
--
ALTER TABLE `maintenance_fine_details`
  ADD CONSTRAINT `FKEED582699439F893` FOREIGN KEY (`maintenance_detail_id`) REFERENCES `maintenance_detail` (`id`);

--
-- Constraints for table `maintenance_schedules`
--
ALTER TABLE `maintenance_schedules`
  ADD CONSTRAINT `FK81C132909F7D7644` FOREIGN KEY (`scheduled_maintenance_types_id`) REFERENCES `scheduled_maintenance_types` (`id`),
  ADD CONSTRAINT `FK81C13290B4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `FK11D365271D3BA0F7` FOREIGN KEY (`material_master_id`) REFERENCES `material_master` (`id`),
  ADD CONSTRAINT `FK11D365275A4C73D` FOREIGN KEY (`material_group_id`) REFERENCES `material_group` (`id`),
  ADD CONSTRAINT `FK11D36527AB3CD243` FOREIGN KEY (`unit_group_id`) REFERENCES `unit_group` (`id`);

--
-- Constraints for table `material_group`
--
ALTER TABLE `material_group`
  ADD CONSTRAINT `FKB4040567E119591A` FOREIGN KEY (`parent_id`) REFERENCES `material_group` (`id`);

--
-- Constraints for table `material_group_has_material`
--
ALTER TABLE `material_group_has_material`
  ADD CONSTRAINT `FK950F504E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FK950F5045A4C73D` FOREIGN KEY (`material_group_id`) REFERENCES `material_group` (`id`);

--
-- Constraints for table `material_master`
--
ALTER TABLE `material_master`
  ADD CONSTRAINT `FKD5CBF87A1CDA6C8` FOREIGN KEY (`industries_id`) REFERENCES `industries` (`id`);

--
-- Constraints for table `material_requisition`
--
ALTER TABLE `material_requisition`
  ADD CONSTRAINT `FKE75F9184939972B2` FOREIGN KEY (`material_requistion_type_id`) REFERENCES `material_requistion_type` (`id`);

--
-- Constraints for table `process_approved_requisitions`
--
ALTER TABLE `process_approved_requisitions`
  ADD CONSTRAINT `FK1C6FFA0F1EA41B0F` FOREIGN KEY (`approve_purchase_request_material_id`) REFERENCES `approve_materials_requisiton` (`id`);

--
-- Constraints for table `project`
--
ALTER TABLE `project`
  ADD CONSTRAINT `FKED904B19F7CD962C` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  ADD CONSTRAINT `FKED904B1917C18CC` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKED904B19B5525E28` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`);

--
-- Constraints for table `purchase_costs`
--
ALTER TABLE `purchase_costs`
  ADD CONSTRAINT `FK70FB2D887C66AEA9` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`id`),
  ADD CONSTRAINT `FK70FB2D88B5525E28` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`);

--
-- Constraints for table `purchase_order`
--
ALTER TABLE `purchase_order`
  ADD CONSTRAINT `FK71A56A90EFBEC048` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);

--
-- Constraints for table `purchase_order_details`
--
ALTER TABLE `purchase_order_details`
  ADD CONSTRAINT `FKA28273938A6BDA08` FOREIGN KEY (`stores_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `FKA282739359C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FKA28273937C66AEA9` FOREIGN KEY (`purchase_order_id`) REFERENCES `purchase_order` (`id`),
  ADD CONSTRAINT `FKA28273939F54180D` FOREIGN KEY (`approve_purchase_request_material_id`) REFERENCES `approve_purchase_request_material` (`id`);

--
-- Constraints for table `purchase_request_material`
--
ALTER TABLE `purchase_request_material`
  ADD CONSTRAINT `FK23DCF455E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FK23DCF45559C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK23DCF4555BDD2B49` FOREIGN KEY (`purchase_request_id`) REFERENCES `purchase_request` (`id`),
  ADD CONSTRAINT `FK23DCF4557380434C` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Constraints for table `reject_purchase_request`
--
ALTER TABLE `reject_purchase_request`
  ADD CONSTRAINT `FK6846CDF159C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK6846CDF1A5ACFF0C` FOREIGN KEY (`purchase_request_material_id`) REFERENCES `purchase_request_material` (`id`);

--
-- Constraints for table `repairs`
--
ALTER TABLE `repairs`
  ADD CONSTRAINT `FK4137D28617C18CC` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `repairs_has_project`
--
ALTER TABLE `repairs_has_project`
  ADD CONSTRAINT `FK7728E23B7380434C` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  ADD CONSTRAINT `FK7728E23BBBB0702C` FOREIGN KEY (`repairs_id`) REFERENCES `repairs` (`id`);

--
-- Constraints for table `repair_order`
--
ALTER TABLE `repair_order`
  ADD CONSTRAINT `FKBB56C1CB4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `requisition_delivery`
--
ALTER TABLE `requisition_delivery`
  ADD CONSTRAINT `FK6B1BEC3759C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK6B1BEC37DC2C1B51` FOREIGN KEY (`requisition_material_activity_Subcontractor_id`) REFERENCES `requisition_material_activity_subcontractor` (`id`);

--
-- Constraints for table `requisition_material`
--
ALTER TABLE `requisition_material`
  ADD CONSTRAINT `FK4BDA356AE92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FK4BDA356AE29B7FDD` FOREIGN KEY (`material_requisition_id`) REFERENCES `material_requisition` (`id`);

--
-- Constraints for table `requisition_material_activity`
--
ALTER TABLE `requisition_material_activity`
  ADD CONSTRAINT `FK66EB6644D6AE9568` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`),
  ADD CONSTRAINT `FK66EB6644448071BE` FOREIGN KEY (`requistion_material_project_id`) REFERENCES `requistion_material_project` (`id`);

--
-- Constraints for table `requisition_material_activity_subcontractor`
--
ALTER TABLE `requisition_material_activity_subcontractor`
  ADD CONSTRAINT `FK596501FA385DA04C` FOREIGN KEY (`subcontractor_id`) REFERENCES `subcontractor` (`id`),
  ADD CONSTRAINT `FK596501FAD86EFE3A` FOREIGN KEY (`requisition_material_activity_id`) REFERENCES `requisition_material_activity` (`id`);

--
-- Constraints for table `requisition_rejection`
--
ALTER TABLE `requisition_rejection`
  ADD CONSTRAINT `FKA27AC42624E81405` FOREIGN KEY (`requisition_delivery_id`) REFERENCES `requisition_delivery` (`id`),
  ADD CONSTRAINT `FKA27AC42659C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Constraints for table `requistion_material_project`
--
ALTER TABLE `requistion_material_project`
  ADD CONSTRAINT `FK8BBE956B7380434C` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  ADD CONSTRAINT `FK8BBE956BA56EA325` FOREIGN KEY (`requisition_material_id`) REFERENCES `requisition_material` (`id`);

--
-- Constraints for table `road_registration`
--
ALTER TABLE `road_registration`
  ADD CONSTRAINT `FK32CD6778B4D2EEAC` FOREIGN KEY (`equipment_id`) REFERENCES `equipment` (`id`);

--
-- Constraints for table `site_transfer_details`
--
ALTER TABLE `site_transfer_details`
  ADD CONSTRAINT `FKBBCF4FE6E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FKBBCF4FE648BBF3BE` FOREIGN KEY (`site_transfer_orders_id`) REFERENCES `site_transfer_orders` (`id`),
  ADD CONSTRAINT `FKBBCF4FE659C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FKBBCF4FE6D5D3393A` FOREIGN KEY (`process_approved_requisitions_id`) REFERENCES `process_approved_requisitions` (`id`);

--
-- Constraints for table `site_transfer_orders`
--
ALTER TABLE `site_transfer_orders`
  ADD CONSTRAINT `FK5B94C0C18A6BDA08` FOREIGN KEY (`stores_id`) REFERENCES `stores` (`id`);

--
-- Constraints for table `site_transfer_requisition`
--
ALTER TABLE `site_transfer_requisition`
  ADD CONSTRAINT `FK33203C405BA849DB` FOREIGN KEY (`ApproveMaterialRequisitionId`) REFERENCES `approve_materials_requisiton` (`id`),
  ADD CONSTRAINT `FK33203C4059C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK33203C40E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`);

--
-- Constraints for table `stock_adjustment`
--
ALTER TABLE `stock_adjustment`
  ADD CONSTRAINT `FK25BF2236E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FK25BF2236301E89D9` FOREIGN KEY (`stock_location_id`) REFERENCES `stock_location` (`id`),
  ADD CONSTRAINT `FK25BF223659C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Constraints for table `stock_location`
--
ALTER TABLE `stock_location`
  ADD CONSTRAINT `FK5DF72BEABBE39EF` FOREIGN KEY (`store_location_id`) REFERENCES `store_location` (`id`),
  ADD CONSTRAINT `FK5DF72BE59C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK5DF72BEB287F12D` FOREIGN KEY (`status_material_id`) REFERENCES `status_material` (`id`),
  ADD CONSTRAINT `FK5DF72BEE92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`);

--
-- Constraints for table `stores`
--
ALTER TABLE `stores`
  ADD CONSTRAINT `FKCAD423B217C18CC` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Constraints for table `stores_has_project`
--
ALTER TABLE `stores_has_project`
  ADD CONSTRAINT `FKEA58D1678A6BDA08` FOREIGN KEY (`stores_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `FKEA58D1677380434C` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Constraints for table `store_in`
--
ALTER TABLE `store_in`
  ADD CONSTRAINT `FK6659C143ABBE39EF` FOREIGN KEY (`store_location_id`) REFERENCES `store_location` (`id`),
  ADD CONSTRAINT `FK6659C14359C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FK6659C1437B327477` FOREIGN KEY (`grn_number`) REFERENCES `store_receive_details` (`grn_number`),
  ADD CONSTRAINT `FK6659C143B287F12D` FOREIGN KEY (`status_material_id`) REFERENCES `status_material` (`id`),
  ADD CONSTRAINT `FK6659C143E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`);

--
-- Constraints for table `store_in_detail`
--
ALTER TABLE `store_in_detail`
  ADD CONSTRAINT `FKB823F2CD31EE27AF` FOREIGN KEY (`store_in_id`) REFERENCES `store_in` (`id`),
  ADD CONSTRAINT `FKB823F2CD59C93C48` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`id`);

--
-- Constraints for table `store_location`
--
ALTER TABLE `store_location`
  ADD CONSTRAINT `FK58D45538A6BDA08` FOREIGN KEY (`stores_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `FK58D4553144D2338` FOREIGN KEY (`parent_id`) REFERENCES `store_location` (`id`);

--
-- Constraints for table `store_material_type`
--
ALTER TABLE `store_material_type`
  ADD CONSTRAINT `FKE2A1307431EE27AF` FOREIGN KEY (`store_in_id`) REFERENCES `store_in` (`id`);

--
-- Constraints for table `store_receive`
--
ALTER TABLE `store_receive`
  ADD CONSTRAINT `FK454AA1858A6BDA08` FOREIGN KEY (`stores_id`) REFERENCES `stores` (`id`),
  ADD CONSTRAINT `FK454AA185ABBE39EF` FOREIGN KEY (`store_location_id`) REFERENCES `store_location` (`id`),
  ADD CONSTRAINT `FK454AA185F9E351EB` FOREIGN KEY (`receving_type_id`) REFERENCES `receving_type` (`id`);

--
-- Constraints for table `store_receive_details`
--
ALTER TABLE `store_receive_details`
  ADD CONSTRAINT `FK560FE5889820A3E5` FOREIGN KEY (`store_receive_id`) REFERENCES `store_receive` (`id`);

--
-- Constraints for table `store_receive_fine_details`
--
ALTER TABLE `store_receive_fine_details`
  ADD CONSTRAINT `FKFC285D37E92C3E68` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`),
  ADD CONSTRAINT `FKFC285D371999AFDE` FOREIGN KEY (`unit_id_damaged`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FKFC285D37488BA184` FOREIGN KEY (`store_receive_details_id`) REFERENCES `store_receive_details` (`id`),
  ADD CONSTRAINT `FKFC285D374C0F0DC` FOREIGN KEY (`unit_id_received`) REFERENCES `unit` (`id`),
  ADD CONSTRAINT `FKFC285D37F0015952` FOREIGN KEY (`unit_id_challan`) REFERENCES `unit` (`id`);

--
-- Constraints for table `subcontractor`
--
ALTER TABLE `subcontractor`
  ADD CONSTRAINT `FKCDCE10B57380434C` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`);

--
-- Constraints for table `subcontractor_has_sub_activity`
--
ALTER TABLE `subcontractor_has_sub_activity`
  ADD CONSTRAINT `FK210A01FD385DA04C` FOREIGN KEY (`subcontractor_id`) REFERENCES `subcontractor` (`id`),
  ADD CONSTRAINT `FK210A01FDEE4DED6D` FOREIGN KEY (`sub_activity_id`) REFERENCES `sub_activity` (`id`);

--
-- Constraints for table `sub_activity`
--
ALTER TABLE `sub_activity`
  ADD CONSTRAINT `FKA8216E2EEE4DED6D` FOREIGN KEY (`sub_activity_id`) REFERENCES `sub_activity` (`id`),
  ADD CONSTRAINT `FKA8216E2ED6AE9568` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id`);

--
-- Constraints for table `supplier`
--
ALTER TABLE `supplier`
  ADD CONSTRAINT `FK9CDBF9CC44A4A9A0` FOREIGN KEY (`group_id`) REFERENCES `supplier_group` (`id`),
  ADD CONSTRAINT `FK9CDBF9CC1CDA6C8` FOREIGN KEY (`industries_id`) REFERENCES `industries` (`id`);

--
-- Constraints for table `unit`
--
ALTER TABLE `unit`
  ADD CONSTRAINT `FK36D984AB3CD243` FOREIGN KEY (`unit_group_id`) REFERENCES `unit_group` (`id`);

--
-- Constraints for table `unit_group`
--
ALTER TABLE `unit_group`
  ADD CONSTRAINT `FK96A400045996E84A` FOREIGN KEY (`default_unit_id`) REFERENCES `unit` (`id`);
SET FOREIGN_KEY_CHECKS=1;
