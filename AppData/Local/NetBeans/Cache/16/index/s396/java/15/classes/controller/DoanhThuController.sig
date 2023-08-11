����   = �
      java/lang/Object <init> ()V  java/util/ArrayList
  	      model/Hotel_Manager dbURL Ljava/lang/String;
      java/sql/DriverManager getConnection )(Ljava/lang/String;)Ljava/sql/Connection;	      controller/DoanhThuController conn Ljava/sql/Connection; �SELECT
MONTH(hd.NgayLap) AS Thang,
SUM(CASE WHEN hd.MaPhieuDichVu IS NOT NULL THEN pd.TongTien ELSE 0 END) AS DoanhThuDichVu,
SUM(CASE WHEN hd.MaPhieuSanPham IS NOT NULL THEN sp.TongTien ELSE 0 END) AS DoanhThuSanPham,
SUM(CASE WHEN hd.MaPhieuDatPhong IS NOT NULL THEN pdp.ThanhTienP ELSE 0 END) AS DoanhThuPhong,
COUNT(ctpd.MaCTDV) AS LuongDichVu,
SUM(ctsp.SoLuong) AS LuongSanPham,
COUNT(DISTINCT pdp.MaPhong) AS SoLuongPhongDat,
SUM(CASE WHEN nh.MaHang IS NOT NULL THEN nh.SoLuong * nh.GiaNhap ELSE 0 END) AS TongGiaNhap,
SUM(hd.TongTien - (CASE WHEN nh.MaHang IS NOT NULL THEN nh.SoLuong * nh.GiaNhap ELSE 0 END)) AS TongDoanhThu
FROM hoadon hd
LEFT JOIN phieudichvu pd ON hd.MaPhieuDichVu = pd.MaPhieuDichVu
LEFT JOIN phieusanpham sp ON hd.MaPhieuSanPham = sp.MaPhieuSanPham
LEFT JOIN phieudatphong pdp ON hd.MaPhieuDatPhong = pdp.MaPhieuDatPhong
LEFT JOIN chitietphieudichvu ctpd ON pd.MaPhieuDichVu = ctpd.MaPhieuDichVu
LEFT JOIN chitietphieusanpham ctsp ON sp.MaPhieuSanPham = ctsp.MaPhieuSanPham
LEFT JOIN mathang mh ON ctsp.MaHang = mh.MaHang
LEFT JOIN nhaphang nh ON MONTH(nh.NgayNhap) = MONTH(hd.NgayLap)
GROUP BY MONTH(hd.NgayLap)
ORDER BY MONTH(hd.NgayLap)	      sql " # $ % & java/sql/Connection createStatement ()Ljava/sql/Statement; ( ) * + , java/sql/Statement executeQuery ((Ljava/lang/String;)Ljava/sql/ResultSet; . / 0 1 2 java/sql/ResultSet next ()Z 4 model/TongDoanhThuModel
 3  7 Thang . 9 : ; 	getString &(Ljava/lang/String;)Ljava/lang/String;
 3 = > ? setThang (Ljava/lang/String;)V A DoanhThuDichVu
 3 C D ? setDoanhthudichvu F DoanhThuSanPham
 3 H I ? setDoanhthusanpham K DoanhThuPhong
 3 M N ? setDoanhthuphong P LuongDichVu
 3 R S ? setSoluongdichvu U LuongSanPham
 3 W X ? setSoluongsanpham Z SoLuongPhongDat
 3 \ ] ? setSoluongphong _ TongGiaNhap
 3 a b ? setTonggianhap d TongDoanhThu
 3 f g ? setTongdoanhthu
  i j k add (Ljava/lang/Object;)Z ( m n  close " m q java/sql/SQLException
 p s t  printStackTrace   v w x makeConcatWithConstants 8(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; z model/tbl_Phong
 y  } MaPhong
 y  � ? 
setMaPhong � 	LoaiPhong
 y � � ? setLoaiPhong � GiaPhong
 y � � ? setGiaPhong
 y � � ? 
setLuotDat
 y � � ? setTongDoanhThuPhong  v � java/lang/RuntimeException � �Uncompilable code - cannot find symbol
  symbol:   method setTongdoanhthu(java.lang.String)
  location: variable model of type model.tbl_HangHoa
 � �  ?  v � model/tbl_DichVu
 �  � MaDichVu
 � � � ? setMadichvu � 	TenDichVu
 � � � ? setTendichvu � SoLanSuDung
 � � � ? setSoLanSuDung � DoanhThu
 � � � ? setDoanhThu Code LineNumberTable LocalVariableTable this Lcontroller/DoanhThuController; TongDoanhThuTheoThang ()Ljava/util/ArrayList; bp Lmodel/TongDoanhThuModel; rs Ljava/sql/ResultSet; ex Ljava/sql/SQLException; arrDoanhThuTheoThang Ljava/util/ArrayList; state Ljava/sql/Statement; LocalVariableTypeTable 0Ljava/util/ArrayList<Lmodel/TongDoanhThuModel;>; StackMapTable 
Exceptions � java/io/IOException 	Signature 2()Ljava/util/ArrayList<Lmodel/TongDoanhThuModel;>; DoanhThuPhongTheoThang ;(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList; model Lmodel/tbl_Phong; phanloaiThang kieuSX arrDoanhThuPhongTheoThang (Ljava/util/ArrayList<Lmodel/tbl_Phong;>; � java/lang/String MethodParameters N(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList<Lmodel/tbl_Phong;>; DoanhThuSanPhamTheoThang arrDoanhThuSanPhamTheoThang *Ljava/util/ArrayList<Lmodel/tbl_HangHoa;>; P(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList<Lmodel/tbl_HangHoa;>; DoanhThuDichVuTheoThang Lmodel/tbl_DichVu; arrDoanhThuDichVuTheoThang )Ljava/util/ArrayList<Lmodel/tbl_DichVu;>; O(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList<Lmodel/tbl_DichVu;>; <clinit> 
SourceFile DoanhThuController.java BootstrapMethods �
 � � � w � $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; ��SELECT
p.MaPhong,
p.LoaiPhong,
p.GiaPhong,
COUNT(pd.MaPhieuDatPhong) AS SoLuongPhongDat,
ISNULL(SUM(DATEDIFF(DAY, pd.NgayDen, pd.NgayDi) * p.GiaPhong), 0) AS TongDoanhThu
FROM phong p
LEFT JOIN phieudatphong pd ON p.MaPhong = pd.MaPhong
AND YEAR(pd.NgayDen) = 2023
AND MONTH(pd.NgayDen) =
GROUP BY p.MaPhong, p.LoaiPhong, p.GiaPhong, DATEDIFF(DAY, pd.NgayDen, pd.NgayDi)
ORDER BY TongDoanhThu  �SELECT mh.MaHang, mh.TenHang, mh.LoaiHang, SUM(ct.SoLuong) AS TongSoLuong, SUM(ct.ThanhTien) AS ThanhTien,
SUM(ct.ThanhTien) - (SUM(ct.SoLuong) * mh.GiaNhap) AS LoiNhuan
FROM hoadon hd
INNER JOIN phieusanpham psp ON hd.MaPhieuSanPham = psp.MaPhieuSanPham
INNER JOIN chitietphieusanpham ct ON psp.MaPhieuSanPham = ct.MaPhieuSanPham
INNER JOIN mathang mh ON ct.MaHang = mh.MaHang
WHERE MONTH(hd.NgayLap) = AND YEAR(hd.NgayLap) = 2023
GROUP BY mh.MaHang, mh.TenHang, mh.LoaiHang, mh.GiaNhap,mh.GiaBan
ORDER BY LoiNhuan  ��SELECT dv.MaDichVu, dv.TenDichVu, COUNT(DISTINCT pdv.MaPhieuDichVu) AS SoLanSuDung, SUM(ct.ThanhTien) AS DoanhThu
FROM phieudichvu pdv
INNER JOIN chitietphieudichvu ct ON pdv.MaPhieuDichVu = ct.MaPhieuDichVu
INNER JOIN dichvu dv ON ct.MaDichVu = dv.MaDichVu
INNER JOIN hoadon hd ON pdv.MaPhieuDatPhong = hd.MaPhieuDatPhong
WHERE MONTH(hd.NgayLap) = AND YEAR(hd.NgayLap) = 2023
GROUP BY dv.MaDichVu, dv.TenDichVu
ORDER BY DoanhThu  InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup !      
     
           �   /     *� �    �        �        � �   	 � �  �  �     ɻ Y� 	KL� 
� � � � � ! L+� � ' M,� - � �� 3Y� 5N-,6� 8 � <-,@� 8 � B-,E� 8 � G-,J� 8 � L-,O� 8 � Q-,T� 8 � V-,Y� 8 � [-,^� 8 � `-,c� 8 � e*-� hW��}+� l � � o � M,� r*�  
 � � p  �   f       
     / ! 0 + 1 4 2 < 3 H 4 T 5 ` 6 l 7 x 8 � 9 � : � ; � < � = � > � ? � B � @ � A � C �   4  < r � �  + � � �  �  � �   � � �   
 � � �  �      � � �   �   " � +  ( .� ��    (  p �     � �    � 	 � �  �  �     �� Y� 	MN� 
� � *+� u  � � � ! N-� � ' :� - � \� yY� {:|� 8 � ~�� 8 � ��� 8 � �Y� 8 � �c� 8 � �,� hW���-� l � � o � 
:� r,�  
 � � p  �   V    G  H 
 J  K  X & Y 1 Z ; [ D \ R ] ` ^ n _ | ` � a � b � c � d � g � e � f � h �   H  D M � �  1 q � �  �  � �    � �      � �    � � �  
 � � �  �      � � �  �   ( � 1  ( .� b�   � �  (  p �     � �   	 �   �   �    � 	 � �  �  5     _� Y� 	MN� 
� � *+� �  � � � ! N-� � ' :� - � � �Y�� ��-� l � � o � 
:� r,�  
 S V p  �   :    l  m 
 o  p  z & { 1 | ;  E � K � S � V � X � ] � �   >  1 " � �  X  � �    _ �      _ �    W � �  
 U � �  �      W � �  �   & � 1  ( .�   � �  (  p �     � �   	 �   �   �    � 	 � �  �  �     �� Y� 	MN� 
� � *+� �  � � � ! N-� � ' :� - � N� �Y� �:�� 8 � ��� 8 � ��� 8 � ��� 8 � �,� hW���-� l � � o � 
:� r,�  
 � � p  �   R    �  � 
 �  �  � & � 1 � ; � D � R � ` � n � | � � � � � � � � � � � � � � � �   H  D ? � �  1 c � �  �  � �    � �      � �    � � �  
 � � �  �      � � �  �   ( � 1  ( .� T�   � �  (  p �     � �   	 �   �   �    �  �   �         � �    �         �    � �     �  � �  � �  � �   
  � � � 