-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 11, 2023 lúc 08:46 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `71dctt21_webkhachsan`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphong`
--

CREATE TABLE `chitietphong` (
  `ID` int(11) NOT NULL,
  `ID_Phong` varchar(50) NOT NULL,
  `TenPhong` varchar(50) NOT NULL,
  `NguoiMax` int(11) NOT NULL,
  `LoaiGiuong` varchar(50) NOT NULL,
  `GiaPhong` int(11) NOT NULL,
  `SoLuongPhong` int(11) NOT NULL,
  `IMG` varchar(50) NOT NULL,
  `DienTich` varchar(50) NOT NULL,
  `TamNhin` varchar(50) NOT NULL,
  `Mota` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietphong`
--

INSERT INTO `chitietphong` (`ID`, `ID_Phong`, `TenPhong`, `NguoiMax`, `LoaiGiuong`, `GiaPhong`, `SoLuongPhong`, `IMG`, `DienTich`, `TamNhin`, `Mota`) VALUES
(1, '1', 'Deluxe Single', 2, '1 Giường Đơn', 100000, 3, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(2, '1', 'Deluxe Twin', 3, '2 Giường Đơn', 150000, 6, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(3, '1', 'Deluxe Double', 3, '1 Giường Đơn và 1 Giường Đôi', 200000, 4, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(4, '1', 'Deluxe Triple', 4, '1 Giường Đôi và 2 Giường Đơn', 200000, 5, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(5, '2', 'Executive Twin', 3, '2 Giường Đơn', 250000, 6, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(7, '2', 'Executive Double', 3, '2 Giường Đơn', 200000, 7, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(8, '3', 'Suite Single', 2, '1 Giường Đơn', 200000, 8, '../img/roomstyle/Deluxe_normal.jpg', '', '', ''),
(9, '3', 'Suite double', 7, '2 Giường Đôi', 350000, 10, '../img/roomstyle/junior_suite.jpg', '', '', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietthanhtoan`
--

CREATE TABLE `chitietthanhtoan` (
  `MaDonHang` int(11) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `SDT` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `TenPhong` varchar(50) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `SoTienPhaiTra` varchar(20) NOT NULL,
  `PhuongThucThanhToan` varchar(100) NOT NULL,
  `NgayDen` datetime NOT NULL,
  `NgayDi` datetime NOT NULL,
  `NgayTT` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietthanhtoan`
--

INSERT INTO `chitietthanhtoan` (`MaDonHang`, `HoTen`, `SDT`, `Email`, `TenPhong`, `SoLuong`, `SoTienPhaiTra`, `PhuongThucThanhToan`, `NgayDen`, `NgayDi`, `NgayTT`) VALUES
(2, 'trịnh tiến quang', '976708122', 'Trinhtienquang2002@gmail.com', 'Deluxe Single', 1, '300000', 'Thanh toán bằng QR-Pay', '2022-12-08 13:20:00', '2022-12-06 13:20:00', '2022-12-07 07:21:00'),
(3, 'trịnh tiến quang', '976708122', 'Trinhtienquang2002@gmail.com', 'Executive Twin', 2, '300000', 'Thẻ ATM/Tài khoản ngân hàng', '2022-12-08 14:27:00', '2022-12-08 14:27:00', '2022-12-07 08:28:00'),
(4, 'Bá Trường', '336004078', 'buck0503@gmail.com', 'Deluxe Double', 1, '550400', 'Thẻ ATM/Tài khoản ngân hàng', '2022-12-11 16:52:00', '2022-12-09 16:52:00', '2022-12-07 10:54:00'),
(5, 'nguyễn hoàng anh', '123456', 'anh@gmail.com', 'Deluxe Single', 1, '400000', 'Thanh toán bằng QR-Pay', '2022-12-08 16:39:00', '2022-12-09 16:39:00', '2022-12-08 10:40:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `dichvu`
--

CREATE TABLE `dichvu` (
  `ID` int(11) NOT NULL,
  `TenDichVu` varchar(50) NOT NULL,
  `DonGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `dichvu`
--

INSERT INTO `dichvu` (`ID`, `TenDichVu`, `DonGia`) VALUES
(1, 'Extrabed', 300000),
(2, 'Xe đưa đón tại sân bay', 250000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `douong`
--

CREATE TABLE `douong` (
  `ID` int(11) NOT NULL,
  `TenDoUong` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `douong`
--

INSERT INTO `douong` (`ID`, `TenDoUong`, `Gia`, `IMG`) VALUES
(1, 'Sprite', '22000 VNĐ', 'Spite.jpg'),
(2, 'Bia', '25000 VNĐ', 'Bia.jpg'),
(3, 'Coca Cola', '20000 VNĐ', 'Coca cola.jpg'),
(4, 'Pepsi', '20000 VNĐ', 'Pepsi.jpg'),
(5, 'Rượu Vang', '300000 VNĐ', 'Rượu vang.jpg'),
(6, 'Rượu Voodka', '300000 VNĐ', 'Rượu voodka.jpg'),
(7, 'Soda', '20000 VNĐ', 'Soda.jpg'),
(8, 'Whisky', '400000 VNĐ', 'Whisky.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monchinh`
--

CREATE TABLE `monchinh` (
  `ID` int(11) NOT NULL,
  `TenMon` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monchinh`
--

INSERT INTO `monchinh` (`ID`, `TenMon`, `Gia`, `IMG`) VALUES
(1, 'Mực Hấp Gừng', '180000 VNĐ', 'Mực hấp gừng.jpg'),
(3, 'Bò né', '200000 VNĐ', 'Bò né.jpg'),
(4, 'Cá bớp nướng muối ớt xanh', '250000 VNĐ', 'Cá bớp nướng muối ớt xanh.jpg'),
(5, 'Cá lóc hấp bầu', '200000 VNĐ', 'Cá lóc hấp bầu.png'),
(6, 'Cá tầm sốt nấm tiêu đen', '300000 VNĐ', 'Cá tầm sốt nấm tiêu đen đút lò.jpg'),
(7, 'Gà bó xôi', '180000 VNĐ', 'Gà bó xôi.jpg'),
(8, 'Lẩu cá thác lác', '250000 VNĐ', 'Lẩu cá thác lác.jpg'),
(9, 'Lẩu gà lá giang', '250000 VNĐ', 'Lẩu gà lá giang.png'),
(10, 'Mực hấp rim mắm tỏi', '120000 VNĐ', 'Mực hấp rim mắm tỏi.jpg'),
(11, 'Mực xào sa tế', '120000 VNĐ', 'Mực xào sa tế.png'),
(12, 'Sườn bò hầm táo đỏ', '500000 VNĐ', 'Sườn bò hầm táo đỏ.jpg'),
(13, 'Sườn sốt bbq đút lò', '500000 VNĐ', 'Sườn sốt BBQ đút lò.jpg'),
(14, 'Thăn heo sốt nho', '400000 VNĐ', 'Thăn heo đút lò sốt nho.png'),
(15, 'Vịt nướng tiêu đen', '300000 VNĐ', 'Vịt nướng tiêu đen.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monkhaivi`
--

CREATE TABLE `monkhaivi` (
  `ID` int(11) NOT NULL,
  `TenMon` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monkhaivi`
--

INSERT INTO `monkhaivi` (`ID`, `TenMon`, `Gia`, `IMG`) VALUES
(1, 'Salad rau củ', '50000 VNĐ', 'Sallat rau củ.png'),
(2, 'Gỏi Bưởi Tôm Mực', '100000 VNĐ', 'Gỏi bưởi tôm mực.jpg'),
(3, 'Bánh Korokke nhân thịt bò', '120000 VNĐ', 'Bánh Korokke nhân thịt bò.jpg'),
(4, 'Bánh xếp nhân thịt', '70000VNĐ', 'Bánh xếp nhân thịt heo chiên giòn.jpg'),
(5, 'Càng cua bách hoa', '150000 VNĐ', 'Càng cua bách hoa.jpg'),
(6, 'Gỏi bò bóp thấu', '150000 VNĐ', 'Gỏi bò bóp thấu.jpg'),
(7, 'Gỏi ngó sen tôm thịt', '100000 VNĐ', 'Gỏi ngó sen tôm thịt.jpg'),
(8, 'Gỏi ngũ sắc hải sản', '80000 VNĐ', 'Gỏi ngũ sắc hải sản.jpg'),
(9, 'Gỏi ngự tiến tôm thịt', '200000 VNĐ', 'Gỏi ngự tiến tôm thịt.jpg'),
(10, 'Salad hải sản chua cay', '100000 VNĐ', 'Sallat hải sản chua cay.jpg'),
(11, 'Sú ghẹ nấm đông cô', '150000 VNĐ', 'Sú ghẹ nấm đông cô.jpg'),
(12, 'Súp cua', '100000 VNĐ', 'Súp cua.jpg'),
(13, 'Súp gà nấm hương', '100000 VNĐ', 'Súp gà nấm hương.jpg'),
(14, 'Thịt nguội bát bửu', '200000 VNĐ', 'Thịt nguội bát bửu.jpg'),
(15, 'Tôm chiên xù', '100000 VNĐ', 'Tôm chiên xù.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monnoibat`
--

CREATE TABLE `monnoibat` (
  `ID` int(11) NOT NULL,
  `TenMon` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `monnoibat`
--

INSERT INTO `monnoibat` (`ID`, `TenMon`, `Gia`, `IMG`) VALUES
(1, 'Bánh xếp nhân thịt', '70000 VNĐ', 'noibat3.jpg'),
(2, 'Tôm Chiên Xù', '100000 VNĐ', 'noibat2.png'),
(3, 'Bánh Korokke nhân thịt bò', '120000 VNĐ', 'noibat1.png'),
(4, 'Bò né', '200000 VNĐ', 'Bò né.jpg'),
(5, 'Gỏi ngũ sắc hải sản', '80000 VNĐ', 'Gỏi ngũ sắc hải sản.jpg'),
(6, 'Súp cua', '100000 VNĐ', 'Súp cua.jpg'),
(7, 'Salad rau củ', '120000 VNĐ', 'Sallat rau củ.png'),
(8, 'Càng cua bách hoa', '150000 VNĐ', 'Càng cua bách hoa.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `montrangmieng`
--

CREATE TABLE `montrangmieng` (
  `ID` int(11) NOT NULL,
  `TenMon` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `montrangmieng`
--

INSERT INTO `montrangmieng` (`ID`, `TenMon`, `Gia`, `IMG`) VALUES
(1, 'Bánh Mochi', '30000 VNĐ', 'Bánh Mochi.jpg'),
(2, 'Bánh Su Kem', '30000 VNĐ', 'Bánh su kem.jpg'),
(3, 'Bánh Cupcake Socola', '50000 VNĐ', 'Bánh cupcake socola.jpg'),
(4, 'Bánh tuyết thiên sứ', '40000 VNĐ', 'Bánh tuyết thiên sứ.jpg'),
(5, 'Chè dưỡng nhan', '80000 VNĐ', 'Chè dưỡng nhan.jpg'),
(6, 'Chè hạt sen nấm tuyết', '50000 VNĐ', 'Chè hạt sen nấm tuyết.jpg'),
(7, 'Chè khúc bạch', '50000 VNĐ', 'Chè khúc bạch.jpg'),
(8, 'Rau câu hoa đậu biếc', '40000 VNĐ', 'Rau câu hoa đậu biếc.png'),
(9, 'Trái Cây', '100000 VNĐ', 'Trái cây.jpg'),
(10, 'Yogurt', '30000 VNĐ', 'Yaourt.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phong`
--

CREATE TABLE `phong` (
  `ID` int(11) NOT NULL,
  `LoaiPhong` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phong`
--

INSERT INTO `phong` (`ID`, `LoaiPhong`) VALUES
(1, 'Deluxe'),
(2, 'Executive'),
(3, 'Suite');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quanlytaikhoan`
--

CREATE TABLE `quanlytaikhoan` (
  `ID` int(100) NOT NULL,
  `HoTen` varchar(100) NOT NULL,
  `SDT` int(12) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `CMND` int(12) NOT NULL,
  `PassWord` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `quanlytaikhoan`
--

INSERT INTO `quanlytaikhoan` (`ID`, `HoTen`, `SDT`, `Email`, `CMND`, `PassWord`) VALUES
(1, 'Trịnh Tiến Quang', 976708122, 'Trinhtienquang2002@gmail.com', 12312312, 0),
(2, 'Bá Trường', 336004076, 'buck1704', 2142315, 1),
(3, 'Thuy Dung', 976708123, 'dungnguyen@gmail.com', 2147483647, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `setbuffet`
--

CREATE TABLE `setbuffet` (
  `ID` int(11) NOT NULL,
  `TenSet` varchar(50) NOT NULL,
  `Gia` varchar(50) NOT NULL,
  `IMG` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `setbuffet`
--

INSERT INTO `setbuffet` (`ID`, `TenSet`, `Gia`, `IMG`) VALUES
(1, 'Set 1', '499000 VNĐ', 'Set1.jpg'),
(2, 'Set 2', '799000 VNĐ', 'Set2.jpg'),
(3, 'Set 3', '999000 VNĐ', 'Set5.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoanadmin`
--

CREATE TABLE `taikhoanadmin` (
  `ID` int(11) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `SDT` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `PassWord` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoanadmin`
--

INSERT INTO `taikhoanadmin` (`ID`, `HoTen`, `SDT`, `Email`, `PassWord`) VALUES
(1, 'Bá Trường', '012345678', 'buck0503@gmail.com', '123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphong`
--
ALTER TABLE `chitietphong`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `chitietthanhtoan`
--
ALTER TABLE `chitietthanhtoan`
  ADD PRIMARY KEY (`MaDonHang`);

--
-- Chỉ mục cho bảng `dichvu`
--
ALTER TABLE `dichvu`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `douong`
--
ALTER TABLE `douong`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `monchinh`
--
ALTER TABLE `monchinh`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `monkhaivi`
--
ALTER TABLE `monkhaivi`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `monnoibat`
--
ALTER TABLE `monnoibat`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `montrangmieng`
--
ALTER TABLE `montrangmieng`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `phong`
--
ALTER TABLE `phong`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `quanlytaikhoan`
--
ALTER TABLE `quanlytaikhoan`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `setbuffet`
--
ALTER TABLE `setbuffet`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `taikhoanadmin`
--
ALTER TABLE `taikhoanadmin`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietphong`
--
ALTER TABLE `chitietphong`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `chitietthanhtoan`
--
ALTER TABLE `chitietthanhtoan`
  MODIFY `MaDonHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `dichvu`
--
ALTER TABLE `dichvu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `douong`
--
ALTER TABLE `douong`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `monchinh`
--
ALTER TABLE `monchinh`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `monkhaivi`
--
ALTER TABLE `monkhaivi`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `monnoibat`
--
ALTER TABLE `monnoibat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `montrangmieng`
--
ALTER TABLE `montrangmieng`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `quanlytaikhoan`
--
ALTER TABLE `quanlytaikhoan`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `setbuffet`
--
ALTER TABLE `setbuffet`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `taikhoanadmin`
--
ALTER TABLE `taikhoanadmin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
