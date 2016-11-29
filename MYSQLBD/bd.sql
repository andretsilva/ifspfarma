-- --------------------------------------------------------
-- Database: `farmasisava`
--
CREATE DATABASE IF NOT EXISTS `farmasisava` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `farmasisava`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE `caixa` (
  `idCaixa` int(11) NOT NULL,
  `dataHoraAbertura` datetime NOT NULL,
  `dataHoraFechamento` datetime DEFAULT NULL,
  `moeda5` int(11) NOT NULL,
  `moeda10` int(11) NOT NULL,
  `moeda25` int(11) NOT NULL,
  `moeda50` int(11) NOT NULL,
  `moeda100` int(11) NOT NULL,
  `nota2` int(11) NOT NULL,
  `nota5` int(11) NOT NULL,
  `nota10` int(11) NOT NULL,
  `nota20` int(11) NOT NULL,
  `nota50` int(11) NOT NULL,
  `nota100` int(11) NOT NULL,
  `valorFinal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `caixa`
--

INSERT INTO `caixa` (`idCaixa`, `dataHoraAbertura`, `dataHoraFechamento`, `moeda5`, `moeda10`, `moeda25`, `moeda50`, `moeda100`, `nota2`, `nota5`, `nota10`, `nota20`, `nota50`, `nota100`, `valorFinal`) VALUES
(1, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(2, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 11, 1, 1, 1, 1, NULL),
(3, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(4, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(5, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(6, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(7, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 30, 0, 0, 0, 0, 0, NULL),
(8, '2016-09-19 00:00:00', NULL, 20, 20, 20, 20, 20, 10, 20, 10, 30, 10, 15, NULL),
(9, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(10, '2016-09-19 00:00:00', NULL, 123, 123, 213, 123, 1, 123, 123, 231, 3, 0, 0, NULL),
(11, '2016-09-19 00:00:00', NULL, 3, 4, 5, 6, 7, 1, 1, 1, 1, 2, 2, NULL),
(12, '2016-09-19 00:00:00', NULL, 3, 4, 5, 2, 3, 123, 1, 2, 3, 4, 5, NULL),
(13, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(14, '2016-09-19 00:00:00', NULL, 2, 2, 3, 4, 5, 11, 1, 0, 1, 1, 2, NULL),
(15, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(16, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(17, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(18, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(19, '2016-09-19 00:00:00', NULL, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, NULL),
(20, '2016-09-19 00:00:00', NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, NULL),
(21, '2016-09-19 00:00:00', NULL, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, NULL),
(22, '2016-10-10 00:00:00', NULL, 1232131, 1, 1, 1, 1, 1231, 11, 1, 1, 1, 1, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientesespeciais`
--

CREATE TABLE `clientesespeciais` (
  `idCliente` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `CPF` varchar(15) NOT NULL,
  `Endereco` varchar(255) NOT NULL,
  `Cidade` varchar(100) NOT NULL,
  `UF` varchar(2) NOT NULL,
  `Bairro` varchar(100) NOT NULL,
  `CEP` varchar(9) NOT NULL,
  `dataNascimento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `clientesespeciais`
--

INSERT INTO `clientesespeciais` (`idCliente`, `nome`, `telefone`, `CPF`, `Endereco`, `Cidade`, `UF`, `Bairro`, `CEP`, `dataNascimento`) VALUES
(1, 'André Silva ', '3534352067', '09287944660', 'rua Xv de novembro 70', 'Extrema', 'MG', 'Centro', '37640-000', '1989-01-05'),
(5, 'adnnre', '210391', '123123', 'teste', 'exa', 'SP', 'xaxa', '2312321', '1989-01-05'),
(7, 'aadsad', '123', '213', 'asdas', '213', 'SP', '123', '213', '1930-01-05'),
(8, 'Alessandro niguem', '(11) 2333-3332', '092.879.446-60', 'Rua das amoras caidas', 'Bragança Paulista', 'SP', 'Centro', '37640-000', '1929-12-05'),
(9, '', '', '111.111.111-11', '', '', 'SP', '', '     -   ', '1940-01-01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `idEstoque` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`idEstoque`, `idMedicamento`, `quantidade`) VALUES
(1, 1, 320),
(2, 9, 10),
(3, 10, 220);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL,
  `login` varchar(30) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `nivel` enum('0','1') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idFuncionario`, `login`, `pwd`, `nivel`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itensvendidos`
--

CREATE TABLE `itensvendidos` (
  `idItemVendido` int(11) NOT NULL,
  `idVenda` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `itensvendidos`
--

INSERT INTO `itensvendidos` (`idItemVendido`, `idVenda`, `idMedicamento`, `quantidade`) VALUES
(1, 17, 1, 12),
(2, 17, 1, 12),
(3, 17, 1, 12),
(4, 17, 1, 12),
(5, 18, 1, 10),
(6, 19, 1, 10),
(7, 20, 9, 5),
(8, 20, 9, 5),
(9, 21, 9, 10),
(10, 22, 1, 10),
(11, 23, 1, 10),
(12, 24, 1, 10),
(13, 25, 1, 1),
(14, 25, 1, 1),
(15, 26, 10, 12),
(16, 26, 10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicamentos`
--

CREATE TABLE `medicamentos` (
  `codigoBarras` varchar(100) NOT NULL,
  `nome` text NOT NULL,
  `fabricante` varchar(100) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `medicamentos`
--

INSERT INTO `medicamentos` (`codigoBarras`, `nome`, `fabricante`, `idMedicamento`, `preco`) VALUES
('300200100', 'Novalgina', 'Scheringer', 1, 20),
('300300300', 'Dipiriona', 'Genérico', 8, 0.4),
('300100200', 'Boldenona 5ml', 'Landerlan', 9, 125),
('20000', 'Torsilax', 'agorasei', 10, 2.55);

-- --------------------------------------------------------

--
-- Estrutura da tabela `opcoesadm`
--

CREATE TABLE `opcoesadm` (
  `idOption` int(11) NOT NULL,
  `option_name` varchar(255) NOT NULL,
  `option_value` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `opcoesadm`
--

INSERT INTO `opcoesadm` (`idOption`, `option_name`, `option_value`) VALUES
(1, 'senhaAbertura', '25f9e794323b453885f5181f1b624d0b'),
(2, 'senhaFechamento', '25f9e794323b453885f5181f1b624d0b'),
(3, 'senhaGerente', '25f9e794323b453885f5181f1b624d0b');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendasefetuadas`
--

CREATE TABLE `vendasefetuadas` (
  `idVenda` int(11) NOT NULL,
  `valorVenda` double NOT NULL,
  `cpfCliente` varchar(15) DEFAULT NULL,
  `dataHoraVenda` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `vendasefetuadas`
--

INSERT INTO `vendasefetuadas` (`idVenda`, `valorVenda`, `cpfCliente`, `dataHoraVenda`) VALUES
(1, 19, NULL, '2016-09-19 00:00:00'),
(2, 19, NULL, '2016-09-19 00:00:00'),
(3, 38, NULL, '2016-09-19 00:00:00'),
(4, 19, NULL, '2016-09-19 00:00:00'),
(5, 323, NULL, '2016-09-19 00:00:00'),
(6, 323, NULL, '2016-09-19 00:00:00'),
(7, 323, NULL, '2016-09-19 00:00:00'),
(8, 19, NULL, '2016-09-19 00:00:00'),
(9, 19, NULL, '2016-09-19 00:00:00'),
(10, 19, NULL, '2016-09-19 00:00:00'),
(11, 19, NULL, '2016-09-19 00:00:00'),
(12, 19, NULL, '2016-09-19 00:00:00'),
(13, 437, NULL, '2016-09-19 00:00:00'),
(14, 437, NULL, '2016-09-19 00:00:00'),
(15, 437, NULL, '2016-09-19 00:00:00'),
(16, 190, NULL, '2016-09-19 00:00:00'),
(17, 912, NULL, '2016-09-19 00:00:00'),
(18, 200, NULL, '2016-09-19 00:00:00'),
(19, 0, NULL, '2016-09-19 00:00:00'),
(20, 0, '092.879.446-60', '2016-09-19 00:00:00'),
(21, 0, NULL, '2016-09-19 00:00:00'),
(22, 0, NULL, '2016-09-19 00:00:00'),
(23, 0, NULL, '2016-09-19 00:00:00'),
(24, 0, NULL, '2016-09-19 00:00:00'),
(25, 0, NULL, '2016-09-19 00:00:00'),
(26, 0, NULL, '2016-09-19 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`idCaixa`);

--
-- Indexes for table `clientesespeciais`
--
ALTER TABLE `clientesespeciais`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `CPF` (`CPF`),
  ADD UNIQUE KEY `idCliente` (`idCliente`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`idEstoque`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `itensvendidos`
--
ALTER TABLE `itensvendidos`
  ADD PRIMARY KEY (`idItemVendido`);

--
-- Indexes for table `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`idMedicamento`),
  ADD UNIQUE KEY `codigoBarras` (`codigoBarras`);

--
-- Indexes for table `opcoesadm`
--
ALTER TABLE `opcoesadm`
  ADD PRIMARY KEY (`idOption`);

--
-- Indexes for table `vendasefetuadas`
--
ALTER TABLE `vendasefetuadas`
  ADD PRIMARY KEY (`idVenda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
  MODIFY `idCaixa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `clientesespeciais`
--
ALTER TABLE `clientesespeciais`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `idEstoque` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `itensvendidos`
--
ALTER TABLE `itensvendidos`
  MODIFY `idItemVendido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `medicamentos`
--
ALTER TABLE `medicamentos`
  MODIFY `idMedicamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `opcoesadm`
--
ALTER TABLE `opcoesadm`
  MODIFY `idOption` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `vendasefetuadas`
--
ALTER TABLE `vendasefetuadas`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;--

