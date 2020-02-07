package org.kapsathon.gonephishin;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = { 
  "amazon.dynamodb.endpoint=http://localhost:8000/", 
  "amazon.aws.accesskey=test1", 
  "amazon.aws.secretkey=test231" })
public class GonephishinApplicationIntegrationTests {
 
    private DynamoDBMapper dynamoDBMapper;
 
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
 
    @Autowired
    ProductInfoRepository repository;
 
    private static final String EXPECTED_COST = "20";
    private static final String EXPECTED_PRICE = "50";
 
    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
         
        CreateTableRequest tableRequest = dynamoDBMapper
          .generateCreateTableRequest(ProductInfo.class);
        tableRequest.setProvisionedThroughput(
          new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);
         
        //...
 
        dynamoDBMapper.batchDelete(
          (List<ProductInfo>)repository.findAll());
    }
 
    @Test
    public void sampleTestCase() {
        ProductInfo dave = new ProductInfo(EXPECTED_COST, EXPECTED_PRICE);
        ProductInfoRepository.save(dave);
 
        List<ProductInfo> result 
          = (List<ProductInfo>) repository.findAll();
         
        assertTrue("Not empty", result.size() > 0);
        assertTrue("Contains item with expected cost", 
          result.get(0).getCost().equals(EXPECTED_COST));
    }
}