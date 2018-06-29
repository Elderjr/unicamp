source("https://www.r-statistics.com/wp-content/uploads/2010/02/Friedman-Test-with-Post-Hoc.r.txt")  # loading the friedman.test.with.post.hoc function from the internet


smallProjects <- data.frame(
  Project = factor(rep(c("Cli", "Csv", "DbUtils"), 3)),
  Threshold = factor(rep(c(7,8,9), each = 3)),
  Coverage = c(0.831,0.774,0.411,
               0.855,0.777,0.413,
               0.852,0.792,0.423),
  Time = c(47,82,27,
           79,107,43,
           101,173,53)
)
smallProjects$Cost = (smallProjects$Coverage * 100) / smallProjects$Time

friedman.test.with.post.hoc(Coverage ~ Threshold | Project, smallProjects)
#Coverage ~ Treshold p-value: 0.1025 (Todas as abordagens são semelhantes)

friedman.test.with.post.hoc(Time ~ Threshold | Project, smallProjects)
#Time ~ Threshold p-value = 0.03793 (Há diferença significativa no tempo de execução)
#Limite 7 e Limite 8: p-value 0.43 (Não há diferença significativa no tempp de execução)
#Limite 7 e Limite 9: p-value 0.03 (Há diferença significativa no tempo de execução)
#Limite 8 e Limite 9: p-value 0.43 (Não há diferença significativa no tempo de execução)

mediumProjects <- data.frame(
  Project = factor(rep(c("Codec", "Chain", "Validator"), 3)),
  Threshold = factor(rep(c(7,8,9), each = 3)),
  Coverage = c(0.794,0.333,0.642,
               0.805,0.446,0.66,
               0.809,0.499,0.68),
  Time = c(293,27,217,
           363,43,293,
           633,238,554)
)
mediumProjects$Cost = (mediumProjects$Coverage * 100) / mediumProjects$Time

friedman.test.with.post.hoc(Coverage ~ Threshold | Project, mediumProjects)
#Coverage ~ Treshold p-value = 0.03797
#Limite 7 e Limite 8: p-value:0.43
#Limite 7 e Limite 9: p-value:0.03
#Limite 8 e Limite 9: p-value:0.43

friedman.test.with.post.hoc(Time ~ Threshold | Project, mediumProjects)
#p-value:0.0379
#7-8:0.43
#7-9:0.03
#8-9:0.43

bigProjects <- data.frame(
  Project = factor(rep(c("Digester", "Lang", "Validator"), 3)),
  Threshold = factor(rep(c(7,8,9), each = 3)),
  Coverage = c(0.44,0.764,0.651,
               0.476,0.796,0.679,
               0.516,0.825,0.741),
  Time = c(356,1118,446,
           512,1674,713,
           1040,2673,1144)
)
bigProjects$Cost = (bigProjects$Coverage * 100) / bigProjects$Time


friedman.test.with.post.hoc(Coverage ~ Threshold | Project, bigProjects)
#p-value:0.0379
#7-8:0.43
#7-9:0.03
#8-9:0.43
friedman.test.with.post.hoc(Time ~ Threshold | Project, bigProjects)
#p-value:0.0379
#7-8:0.43
#7-9:0.03
#8-9:0.43

#Resumo
#Projeto pequeno -> Cobertura não impacta / Temp. Exec Impacta, 7-8 e 8-9 não tem diferença, mas 7-9 sim
#Conclusão: Limite 7 é o melhor em custo-benefício, cobertura não impacta e o tempo de execução é menor
#Projeto médio e grande -> Cobertura e Temp Exec Impacta, 7-8 e 8-9 não tem diferença, mas 7-9 sim
