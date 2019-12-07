-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2018 at 02:26 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tabungan_haji`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_password`
--

CREATE TABLE `admin_password` (
  `admin` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_password`
--

INSERT INTO `admin_password` (`admin`, `password`) VALUES
('admin', 'pass'),
('qohar', 'qohar');

-- --------------------------------------------------------

--
-- Table structure for table `data_peserta`
--

CREATE TABLE `data_peserta` (
  `id_jamaah` int(11) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `alamat` varchar(60) DEFAULT NULL,
  `tempatlahir` varchar(20) DEFAULT NULL,
  `tanggallahir` varchar(2) NOT NULL,
  `bulanlahir` varchar(10) NOT NULL,
  `tahunlahir` varchar(4) NOT NULL,
  `jenis_kelamin` enum('Laki-laki','Perempuan') DEFAULT NULL,
  `jenis_haji` varchar(10) DEFAULT NULL,
  `batas_angsuran` int(11) NOT NULL,
  `nomor_telepon` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_peserta`
--

INSERT INTO `data_peserta` (`id_jamaah`, `nama`, `alamat`, `tempatlahir`, `tanggallahir`, `bulanlahir`, `tahunlahir`, `jenis_kelamin`, `jenis_haji`, `batas_angsuran`, `nomor_telepon`) VALUES
(1001, 'Rizki Fitriani', 'Jambewangi - Selopuro - Blitar', 'Balikpapan', '28', 'Mei', '1999', 'Perempuan', 'Khusus', 170000000, '081234567890'),
(1002, 'ABD. Qohar Agus Maulana', 'Jember', 'Jember', '31', 'Agustus', '1997', 'Laki-laki', 'Khusus', 250000000, '08225788807'),
(1003, 'Inna Fathimatuzzahro', 'Tulungagung', 'Tulungagung', '01', 'Januari', '2000', 'Perempuan', 'Reguler', 150000000, '081509304094'),
(1004, 'AAN', 'Jambewangi', 'asdia', '01', 'Januari', '2009', 'Laki-laki', 'Reguler', 9000000, '0989099090');

-- --------------------------------------------------------

--
-- Table structure for table `rincian`
--

CREATE TABLE `rincian` (
  `id` int(11) NOT NULL,
  `tanggal_nabung` varchar(7) DEFAULT NULL,
  `bulan_nabung` varchar(11) NOT NULL,
  `tahun_nabung` varchar(5) NOT NULL,
  `tabungan` int(11) DEFAULT NULL,
  `id_jamaah` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rincian`
--

INSERT INTO `rincian` (`id`, `tanggal_nabung`, `bulan_nabung`, `tahun_nabung`, `tabungan`, `id_jamaah`) VALUES
(12, '04', 'Desember', '2018', 10000000, 1001),
(16, '01', 'Januari', '2018', 1000000, 1003),
(17, '06', 'Desember', '2018', 1000000, 1002),
(18, '01', 'Januari', '2018', 1000000, 1004);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_password`
--
ALTER TABLE `admin_password`
  ADD PRIMARY KEY (`admin`);

--
-- Indexes for table `data_peserta`
--
ALTER TABLE `data_peserta`
  ADD PRIMARY KEY (`id_jamaah`);

--
-- Indexes for table `rincian`
--
ALTER TABLE `rincian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_jamaah` (`id_jamaah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rincian`
--
ALTER TABLE `rincian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rincian`
--
ALTER TABLE `rincian`
  ADD CONSTRAINT `rincian_ibfk_1` FOREIGN KEY (`id_jamaah`) REFERENCES `data_peserta` (`id_jamaah`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
